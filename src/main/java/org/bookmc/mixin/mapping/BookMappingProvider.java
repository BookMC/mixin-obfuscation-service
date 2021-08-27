package org.bookmc.mixin.mapping;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.Gson;
import org.bookmc.mixin.data.Mappings;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mapping.IMappingProvider;

import java.io.*;
import java.util.Map;

public class BookMappingProvider implements IMappingProvider {
    private final Gson gson = new Gson();

    public final BiMap<String, String> classesMap = HashBiMap.create();
    public final BiMap<MappingField, MappingField> fieldMap = HashBiMap.create();
    public final BiMap<MappingMethod, MappingMethod> methodMap = HashBiMap.create();

    @Override
    public void read(File input) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)))) {
            Mappings mappings = gson.fromJson(reader, Mappings.class);

            for (Map.Entry<String, String> clazz : mappings.getClasses().entrySet()) {
                classesMap.put(clazz.getKey(), clazz.getValue());
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

    @Override
    public void clear() {
        this.classesMap.clear();
        this.fieldMap.clear();
        this.methodMap.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.classesMap.isEmpty() && this.fieldMap.isEmpty() && this.methodMap.isEmpty();
    }

    @Override
    public MappingMethod getMethodMapping(MappingMethod method) {
        return this.methodMap.getOrDefault(method, method);
    }

    @Override
    public MappingField getFieldMapping(MappingField field) {
        return this.fieldMap.getOrDefault(field, field);
    }

    @Override
    public String getClassMapping(String className) {
        return this.classesMap.getOrDefault(className, className);
    }

    @Override
    public String getPackageMapping(String packageName) {
        return packageName;
    }
}
