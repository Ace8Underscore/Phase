package io.ace.phase.manager;

import io.ace.phase.extendable.Module;
import io.ace.phase.module.client.ClickGui;
import io.ace.phase.module.misc.POC;
import io.ace.phase.module.misc.ThunderDeath;

import java.util.ArrayList;

public class ModuleManager {

    public ModuleManager() {
    intModules();
    categoryArrayList = new ArrayList<Module.Category>();
    categoryArrayList.add(Module.Category.COMBAT);
    categoryArrayList.add(Module.Category.GUI);
    categoryArrayList.add(Module.Category.MISC);
    }

    public static ArrayList<Module> modules;
    public static ArrayList<Module.Category> categoryArrayList;

    public static void addHack(Module m){
        modules.add(m);
    }

    public void intModules() {
        modules = new ArrayList<Module>();
        addHack(new ThunderDeath());
        addHack(new POC());
        addHack(new ClickGui());
    }

}
