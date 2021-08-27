package org.bookmc.mixin.descriptor;

import org.bookmc.mixin.BookMixinObfuscationService;
import org.bookmc.mixin.environment.BookMixinObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

public class BookMixinObfuscationTypeDescriptor extends ObfuscationTypeDescriptor {
    public BookMixinObfuscationTypeDescriptor() {
        super("pufferfishgradle", BookMixinObfuscationService.IN_MAP_FILE, BookMixinObfuscationService.OUT_MAP_FILE, BookMixinObfuscationEnvironment.class);
    }
}
