package org.bookmc.mixin.descriptor;

import org.bookmc.mixin.environment.BookMixinObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

public class BookMixinObfuscationTypeDescriptor extends ObfuscationTypeDescriptor {
    public BookMixinObfuscationTypeDescriptor(String key, String inputFileArgName, String outFileArgName) {
        super(key, inputFileArgName, outFileArgName, BookMixinObfuscationEnvironment.class);
    }
}
