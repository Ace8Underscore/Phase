package io.ace.phase.manager;

import io.ace.phase.extendable.Module;
import io.ace.phase.module.misc.POC;
import io.ace.phase.module.misc.ThunderDeath;

import java.util.ArrayList;

public class ModuleManager {

    public ModuleManager() {
    intModules();
    }

    public static ArrayList<Module> modules;

    public static void addHack(Module m){
        modules.add(m);
    }

    public void intModules() {
        modules = new ArrayList<Module>();
        addHack(new POC());
        addHack(new ThunderDeath());
    }

}
