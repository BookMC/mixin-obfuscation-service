package org.bookmc.mixin.mapping;

import com.google.gson.JsonObject;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mapping.common.MappingWriter;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import java.io.IOException;
import java.io.PrintWriter;

public class BookMappingWriter extends MappingWriter {
    public BookMappingWriter(Messager messager, Filer filer) {
        super(messager, filer);
    }

    @Override
    public void write(String output, ObfuscationType type, IMappingConsumer.MappingSet<MappingField> fields, IMappingConsumer.MappingSet<MappingMethod> methods) {
        if (output != null) {
            try (PrintWriter writer = openFileWriter(output, type + " mappings")) {
                JsonObject object = new JsonObject();
                JsonObject fieldsObject = new JsonObject();
                JsonObject methodsObject = new JsonObject();
                for (IMappingConsumer.MappingSet.Pair<MappingField> field : fields) {
                    fieldsObject.addProperty(createFieldMapping(field.from), createFieldMapping(field.to));
                }
                for (IMappingConsumer.MappingSet.Pair<MappingMethod> method : methods) {
                    methodsObject.addProperty(createMethodMapping(method.from), createMethodMapping(method.to));
                }
                object.add("fields", fieldsObject);
                object.add("methods", methodsObject);
                writer.println(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String createFieldMapping(MappingField field) {
        return field.getOwner() + "/" + field.getName() + " " + (field.getDesc() != null ? field.getDesc() : "");
    }

    private String createMethodMapping(MappingMethod method) {
        return method.getOwner() + "/" + method.getName() + " " + method.getDesc();
    }
}
