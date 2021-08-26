package org.bookmc.mixin;

import org.bookmc.mixin.environment.BookMixinObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.SupportedOptions;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.service.IObfuscationService;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

import java.util.*;

//public class BookMixinObfuscationService implements IObfuscationService {
//    public static final String SEARGE                  = "searge";
//    public static final String NOTCH                   = "notch";
//
//    public static final String REOBF_SRG_FILE          = "reobfSrgFile";
//    public static final String REOBF_EXTRA_SRG_FILES   = "reobfSrgFiles";
//    public static final String REOBF_NOTCH_FILE        = "reobfNotchSrgFile";
//    public static final String REOBF_EXTRA_NOTCH_FILES = "reobfNotchSrgFiles";
//    public static final String OUT_SRG_SRG_FILE        = "outSrgFile";
//    public static final String OUT_NOTCH_SRG_FILE      = "outNotchSrgFile";
//
//    @Override
//    public Set<String> getSupportedOptions() {
//        return ImmutableSet.<String>of(
//            ObfuscationServiceMCP.REOBF_SRG_FILE,
//            ObfuscationServiceMCP.REOBF_EXTRA_SRG_FILES,
//            ObfuscationServiceMCP.REOBF_NOTCH_FILE,
//            ObfuscationServiceMCP.REOBF_EXTRA_NOTCH_FILES,
//            ObfuscationServiceMCP.OUT_SRG_SRG_FILE,
//            ObfuscationServiceMCP.OUT_NOTCH_SRG_FILE
//        );
//    }
//
//    @Override
//    public Collection<ObfuscationTypeDescriptor> getObfuscationTypes(IMixinAnnotationProcessor ap) {
//        List<ObfuscationTypeDescriptor> list = new ArrayList<>();
//        if (!ap.getOptions(SupportedOptions.MAPPING_TYPES).contains("tsrg")) {
//            list.add(
//                new ObfuscationTypeDescriptor(
//                    ObfuscationServiceMCP.SEARGE,
//                    ObfuscationServiceMCP.REOBF_SRG_FILE,
//                    ObfuscationServiceMCP.REOBF_EXTRA_SRG_FILES,
//                    ObfuscationServiceMCP.OUT_SRG_SRG_FILE,
//                    ObfuscationEnvironmentMCP.class
//                )
//            );
//        }
//        list.add(
//            new ObfuscationTypeDescriptor(
//                ObfuscationServiceMCP.NOTCH,
//                ObfuscationServiceMCP.REOBF_NOTCH_FILE,
//                ObfuscationServiceMCP.REOBF_EXTRA_NOTCH_FILES,
//                ObfuscationServiceMCP.OUT_NOTCH_SRG_FILE,
//                ObfuscationEnvironmentMCP.class
//            )
//        );
//        return list;
//    }
//}
