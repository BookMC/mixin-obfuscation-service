package org.bookmc.mixin.descriptor;

import org.bookmc.mixin.environment.BookMixinObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

public class BookMixinObfuscationTypeDescriptor extends ObfuscationTypeDescriptor {
    public BookMixinObfuscationTypeDescriptor() {
        super("bookmc-json", "mappingsJsonInput", "generatedOutput", BookMixinObfuscationEnvironment.class);
    }
}
