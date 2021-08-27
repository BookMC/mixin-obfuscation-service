package org.bookmc.mixin.environment;

import org.bookmc.mixin.mapping.BookMappingProvider;
import org.bookmc.mixin.mapping.BookMappingWriter;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.mapping.IMappingProvider;
import org.spongepowered.tools.obfuscation.mapping.IMappingWriter;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;

public class BookMixinObfuscationEnvironment extends ObfuscationEnvironment {
    protected BookMixinObfuscationEnvironment(ObfuscationType type) {
        super(type);
    }

    @Override
    protected IMappingProvider getMappingProvider(Messager messager, Filer filer) {
        return new BookMappingProvider(messager, filer);
    }

    @Override
    protected IMappingWriter getMappingWriter(Messager messager, Filer filer) {
        return new BookMappingWriter(messager, filer);
    }
}
