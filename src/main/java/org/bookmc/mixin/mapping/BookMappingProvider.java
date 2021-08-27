package org.bookmc.mixin.mapping;

import com.google.gson.Gson;
import org.bookmc.mixin.data.Mappings;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mapping.common.MappingProvider;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import java.io.*;
import java.util.Map;

public class BookMappingProvider extends MappingProvider {
    private final Gson gson = new Gson();

    public BookMappingProvider(Messager messager, Filer filer) {
        super(messager, filer);
    }

    @Override
    public void read(File input) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)))) {
            Mappings mappings = gson.fromJson(reader, Mappings.class);

            for (Map.Entry<String, String> clazz : mappings.getClasses().entrySet()) {
                classMap.put(clazz.getKey(), clazz.getValue());
            }

            for (Map.Entry<String, String> method : mappings.getMethods().entrySet()) {
                String[] split = method.getKey().split(" ");

                String[] valueSplit = method.getValue().split(" ");

                methodMap.put(new MappingMethod(split[0], split[1]), new MappingMethod(valueSplit[0], valueSplit[1]));
            }

            for (Map.Entry<String, String> field : mappings.getFields().entrySet()) {
                String[] keySplit = field.getKey().split(" ");
                String[] valueSplit = field.getValue().split(" ");

                String deobfString = valueSplit[0];
                int deobfNameIndex = deobfString.lastIndexOf('/');
                String deobfName = deobfString.substring(deobfNameIndex + 1);
                String deobfOwner = deobfString.substring(0, deobfNameIndex);

                String obfString = keySplit[0];
                int obfNameIndex = obfString.lastIndexOf('/');
                String obfName = obfString.substring(obfNameIndex + 1);
                String obfOwner = obfString.substring(0, obfNameIndex);

                if (keySplit.length == 1) {
                    fieldMap.put(new MappingField(deobfOwner, deobfName, null), new MappingField(obfOwner, obfName, null));
                } else {
                    fieldMap.put(new MappingField(obfOwner, obfName, valueSplit[1]), new MappingField(deobfOwner, deobfName, keySplit[1]));
                }
            }
        }
    }

}
