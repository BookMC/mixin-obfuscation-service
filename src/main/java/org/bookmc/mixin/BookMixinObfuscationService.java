package org.bookmc.mixin;

import org.bookmc.mixin.descriptor.BookMixinObfuscationTypeDescriptor;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.service.IObfuscationService;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

import java.util.*;

/**
 * A simple obfuscation service to assist converting PufferfishGradle generated data
 * into Mixin refmap files. This is built for the annotation processor and would be used
 * by the "annotation-processor-configuration" gradle plugin. Check out more about it
 * at https://github.com/BookMC/annotation-processor-configuration
 */
public class BookMixinObfuscationService implements IObfuscationService {
    public static final String IN_MAP_FILE = "inMapFile";
    public static final String OUT_MAP_FILE = "outMapFile";

    @Override
    public Set<String> getSupportedOptions() {
        return Set.of(IN_MAP_FILE, OUT_MAP_FILE);
    }

    @Override
    public Collection<ObfuscationTypeDescriptor> getObfuscationTypes(IMixinAnnotationProcessor ap) {
        return Collections.singletonList(new BookMixinObfuscationTypeDescriptor());
    }
}
