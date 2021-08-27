package org.bookmc.mixin;

import org.bookmc.mixin.descriptor.BookMixinObfuscationTypeDescriptor;
import org.bookmc.mixin.environment.BookMixinObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.SupportedOptions;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.service.IObfuscationService;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

import java.util.*;

public class BookMixinObfuscationService implements IObfuscationService {
    public static final String MAPPINGS_JSON_INPUT = "mappingsJsonInput";
    public static final String GENERATED_OUTPUT = "generatedOutput";

    @Override
    public Set<String> getSupportedOptions() {
        return Set.of(MAPPINGS_JSON_INPUT, GENERATED_OUTPUT);
    }

    @Override
    public Collection<ObfuscationTypeDescriptor> getObfuscationTypes(IMixinAnnotationProcessor ap) {
        List<ObfuscationTypeDescriptor> list = new ArrayList<>();
        list.add(new BookMixinObfuscationTypeDescriptor());
        return list;
    }
}
