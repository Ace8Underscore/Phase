package io.ace.phase.manager;

import io.ace.phase.extendable.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.glfw.GLFW;

public class BindManager {

    public BindManager() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void keyboardListener(InputEvent.KeyInputEvent event) {
        // make sure we dont toggle modules when in guis
        if (Minecraft.getInstance().screen != null) return;
        //below action 1 is when the key is pressed down action 2 should be when key is released and if no action is used it will spam
        if (event.getAction() == 1) { //Phase.LOGGER.info(event.getKey() + " Was Just Pressed" + event.getScanCode());
            // keybinding debug stuff ChatManager.sendChat("key just pressed " + event.getKey());
            for (Module m : ModuleManager.modules) {
                if (m.getBindKeyCode() == event.getKey()) {
                    m.toggle();
                }
            }
        }
    }
// code below is something made to convert chars to their right int key check io.ace.phase.command.Bind for POC
    public static String getKeyName(int key) {
        switch (key) {
            case GLFW.GLFW_KEY_UNKNOWN: return "Unknown";
            case GLFW.GLFW_KEY_ESCAPE: return "Esc";
            case GLFW.GLFW_KEY_PRINT_SCREEN: return "Print Screen";
            case GLFW.GLFW_KEY_PAUSE: return "Pause";
            case GLFW.GLFW_KEY_INSERT: return "Insert";
            case GLFW.GLFW_KEY_HOME: return "Home";
            case GLFW.GLFW_KEY_PAGE_UP: return "Page Up";
            case GLFW.GLFW_KEY_PAGE_DOWN: return "Page Down";
            case GLFW.GLFW_KEY_END: return "End";
            case GLFW.GLFW_KEY_TAB: return "Tab";
            case GLFW.GLFW_KEY_LEFT_CONTROL: return "Left Control";
            case GLFW.GLFW_KEY_RIGHT_CONTROL: return "Right Control";
            case GLFW.GLFW_KEY_LEFT_ALT: return "Left Alt";
            case GLFW.GLFW_KEY_RIGHT_ALT: return "Right Alt";
            case GLFW.GLFW_KEY_LEFT_SHIFT: return "Left Shift";
            case GLFW.GLFW_KEY_RIGHT_SHIFT: return "Right Shift";
            case GLFW.GLFW_KEY_UP: return "Arrow Up";
            case GLFW.GLFW_KEY_DOWN: return "Arrow Down";
            case GLFW.GLFW_KEY_LEFT: return "Arrow Left";
            case GLFW.GLFW_KEY_RIGHT: return "Arrow Right";
            case GLFW.GLFW_KEY_APOSTROPHE: return "Apostrophe";
            case GLFW.GLFW_KEY_BACKSPACE: return "Backspace";
            case GLFW.GLFW_KEY_CAPS_LOCK: return "Caps Lock";
            case GLFW.GLFW_KEY_MENU: return "Menu";
            case GLFW.GLFW_KEY_LEFT_SUPER: return "Left Super";
            case GLFW.GLFW_KEY_RIGHT_SUPER: return "Right Super";
            case GLFW.GLFW_KEY_ENTER: return "Enter";
            case GLFW.GLFW_KEY_NUM_LOCK: return "Num Lock";
            case GLFW.GLFW_KEY_SPACE: return "Space";
            case GLFW.GLFW_KEY_F1: return "F1";
            case GLFW.GLFW_KEY_F2: return "F2";
            case GLFW.GLFW_KEY_F3: return "F3";
            case GLFW.GLFW_KEY_F4: return "F4";
            case GLFW.GLFW_KEY_F5: return "F5";
            case GLFW.GLFW_KEY_F6: return "F6";
            case GLFW.GLFW_KEY_F7: return "F7";
            case GLFW.GLFW_KEY_F8: return "F8";
            case GLFW.GLFW_KEY_F9: return "F9";
            case GLFW.GLFW_KEY_F10: return "F10";
            case GLFW.GLFW_KEY_F11: return "F11";
            case GLFW.GLFW_KEY_F12: return "F12";
            case GLFW.GLFW_KEY_F13: return "F13";
            case GLFW.GLFW_KEY_F14: return "F14";
            case GLFW.GLFW_KEY_F15: return "F15";
            case GLFW.GLFW_KEY_F16: return "F16";
            case GLFW.GLFW_KEY_F17: return "F17";
            case GLFW.GLFW_KEY_F18: return "F18";
            case GLFW.GLFW_KEY_F19: return "F19";
            case GLFW.GLFW_KEY_F20: return "F20";
            case GLFW.GLFW_KEY_F21: return "F21";
            case GLFW.GLFW_KEY_F22: return "F22";
            case GLFW.GLFW_KEY_F23: return "F23";
            case GLFW.GLFW_KEY_F24: return "F24";
            case GLFW.GLFW_KEY_F25: return "F25";
            default:
                String keyName = GLFW.glfwGetKeyName(key, 0);
                if (keyName == null) return "Unknown";
                return StringUtils.capitalize(keyName);
        }
    }
    public static int getKeyInt(String key) {
        return switch (key.toLowerCase()) {
            case "a" -> GLFW.GLFW_KEY_A;
            case "b" -> GLFW.GLFW_KEY_B;
            case "c" -> GLFW.GLFW_KEY_C;
            case "d" -> GLFW.GLFW_KEY_D;
            case "e" -> GLFW.GLFW_KEY_E;
            case "f" -> GLFW.GLFW_KEY_F;
            case "g" -> GLFW.GLFW_KEY_G;
            case "h" -> GLFW.GLFW_KEY_H;
            case "i" -> GLFW.GLFW_KEY_I;
            case "j" -> GLFW.GLFW_KEY_J;
            case "k" -> GLFW.GLFW_KEY_K;
            case "l" -> GLFW.GLFW_KEY_L;
            case "m" -> GLFW.GLFW_KEY_M;
            case "n" -> GLFW.GLFW_KEY_N;
            case "o" -> GLFW.GLFW_KEY_O;
            case "p" -> GLFW.GLFW_KEY_P;
            case "q" -> GLFW.GLFW_KEY_Q;
            case "r" -> GLFW.GLFW_KEY_R;
            case "s" -> GLFW.GLFW_KEY_S;
            case "t" -> GLFW.GLFW_KEY_T;
            case "u" -> GLFW.GLFW_KEY_U;
            case "v" -> GLFW.GLFW_KEY_V;
            case "w" -> GLFW.GLFW_KEY_W;
            case "x" -> GLFW.GLFW_KEY_X;
            case "y" -> GLFW.GLFW_KEY_Y;
            case "z" -> GLFW.GLFW_KEY_Z;
            case "`" -> GLFW.GLFW_KEY_GRAVE_ACCENT;
            case "tab" -> GLFW.GLFW_KEY_TAB;
            case "capslock" -> GLFW.GLFW_KEY_CAPS_LOCK;
            case "lshift" -> GLFW.GLFW_KEY_LEFT_SHIFT;
            case "lctrl" -> GLFW.GLFW_KEY_LEFT_CONTROL;
            case "lalt" -> GLFW.GLFW_KEY_LEFT_ALT;
            case "1" -> GLFW.GLFW_KEY_1;
            case "2" -> GLFW.GLFW_KEY_2;
            case "3" -> GLFW.GLFW_KEY_3;
            case "4" -> GLFW.GLFW_KEY_4;
            case "5" -> GLFW.GLFW_KEY_5;
            case "6" -> GLFW.GLFW_KEY_6;
            case "7" -> GLFW.GLFW_KEY_7;
            case "8" -> GLFW.GLFW_KEY_8;
            case "9" -> GLFW.GLFW_KEY_9;
            case "0" -> GLFW.GLFW_KEY_0;
            case "f1" -> GLFW.GLFW_KEY_F1;
            case "f2" -> GLFW.GLFW_KEY_F2;
            case "f3" -> GLFW.GLFW_KEY_F3;
            case "f4" -> GLFW.GLFW_KEY_F4;
            case "f5" -> GLFW.GLFW_KEY_F5;
            case "f6" -> GLFW.GLFW_KEY_F6;
            case "f7" -> GLFW.GLFW_KEY_F7;
            case "f8" -> GLFW.GLFW_KEY_F8;
            case "f9" -> GLFW.GLFW_KEY_F9;
            case "f10" -> GLFW.GLFW_KEY_F10;
            case "f11" -> GLFW.GLFW_KEY_F11;
            case "f12" -> GLFW.GLFW_KEY_F12;
            case "[" -> GLFW.GLFW_KEY_LEFT_BRACKET;
            case "]" -> GLFW.GLFW_KEY_RIGHT_BRACKET;
            case "\"" -> GLFW.GLFW_KEY_BACKSLASH;
            case "-" -> GLFW.GLFW_KEY_MINUS;
            case "=" -> GLFW.GLFW_KEY_EQUAL;
            case ";" -> GLFW.GLFW_KEY_SEMICOLON;
            case "'" -> GLFW.GLFW_KEY_APOSTROPHE;
            case "," -> GLFW.GLFW_KEY_COMMA;
            case "." -> GLFW.GLFW_KEY_PERIOD;
            case "/" -> GLFW.GLFW_KEY_SLASH;
            case "rshift" -> GLFW.GLFW_KEY_RIGHT_SHIFT;
            case "rctrl" -> GLFW.GLFW_KEY_RIGHT_CONTROL;
            case "ralt" -> GLFW.GLFW_KEY_RIGHT_ALT;
            case "up" -> GLFW.GLFW_KEY_UP;
            case "down" -> GLFW.GLFW_KEY_DOWN;
            case "left" -> GLFW.GLFW_KEY_LEFT;
            case "right" -> GLFW.GLFW_KEY_RIGHT;
            case "printscreen" -> GLFW.GLFW_KEY_PRINT_SCREEN;
            case "scrolllock" -> GLFW.GLFW_KEY_SCROLL_LOCK;
            case "pausebreak" -> GLFW.GLFW_KEY_PAUSE;
            case "insert" -> GLFW.GLFW_KEY_INSERT;
            case "home" -> GLFW.GLFW_KEY_HOME;
            case "end" -> GLFW.GLFW_KEY_END;
            case "pagedown" -> GLFW.GLFW_KEY_PAGE_DOWN;
            case "numlock" -> GLFW.GLFW_KEY_NUM_LOCK;
            case "num*" -> GLFW.GLFW_KEY_KP_MULTIPLY;
            case "num7" -> GLFW.GLFW_KEY_KP_7;
            case "num8" -> GLFW.GLFW_KEY_KP_8;
            case "num9" -> GLFW.GLFW_KEY_KP_9;
            case "num+" -> GLFW.GLFW_KEY_KP_ADD;
            case "num/" -> GLFW.GLFW_KEY_KP_DIVIDE;
            case "num4" -> GLFW.GLFW_KEY_KP_4;
            case "num5" -> GLFW.GLFW_KEY_KP_5;
            case "num6" -> GLFW.GLFW_KEY_KP_6;
            case "num1" -> GLFW.GLFW_KEY_KP_1;
            case "num2" -> GLFW.GLFW_KEY_KP_2;
            case "num3" -> GLFW.GLFW_KEY_KP_3;
            case "num0" -> GLFW.GLFW_KEY_KP_0;
            case "num." -> GLFW.GLFW_KEY_KP_DECIMAL;
            case "none" -> -189321754;
            default -> -189321754;
        };
    }

    public static String getKeyString(int key) {
        return switch (key) {
            case GLFW.GLFW_KEY_A -> "a";
            case GLFW.GLFW_KEY_B -> "b";
            case GLFW.GLFW_KEY_C -> "c";
            case GLFW.GLFW_KEY_D -> "d";
            case GLFW.GLFW_KEY_E -> "e";
            case GLFW.GLFW_KEY_F -> "f";
            case GLFW.GLFW_KEY_G -> "g";
            case GLFW.GLFW_KEY_H -> "h";
            case GLFW.GLFW_KEY_I -> "i";
            case GLFW.GLFW_KEY_J -> "j";
            case GLFW.GLFW_KEY_K -> "k";
            case GLFW.GLFW_KEY_L -> "l";
            case GLFW.GLFW_KEY_M -> "m";
            case GLFW.GLFW_KEY_N -> "n";
            case GLFW.GLFW_KEY_O -> "o";
            case GLFW.GLFW_KEY_P -> "p";
            case GLFW.GLFW_KEY_Q -> "q";
            case GLFW.GLFW_KEY_R -> "r";
            case GLFW.GLFW_KEY_S -> "s";
            case GLFW.GLFW_KEY_T -> "t";
            case GLFW.GLFW_KEY_U -> "u";
            case GLFW.GLFW_KEY_V -> "v";
            case GLFW.GLFW_KEY_W -> "w";
            case GLFW.GLFW_KEY_X -> "x";
            case GLFW.GLFW_KEY_Y -> "y";
            case GLFW.GLFW_KEY_Z -> "z";
            case GLFW.GLFW_KEY_GRAVE_ACCENT -> "`";
            case GLFW.GLFW_KEY_TAB -> "Tab";
            case GLFW.GLFW_KEY_CAPS_LOCK -> "CapsLock";
            case GLFW.GLFW_KEY_LEFT_SHIFT -> "LShift";
            case GLFW.GLFW_KEY_LEFT_CONTROL -> "LCtrl";
            case GLFW.GLFW_KEY_LEFT_ALT -> "LAlt";
            case GLFW.GLFW_KEY_1 -> "1";
            case GLFW.GLFW_KEY_2 -> "2";
            case GLFW.GLFW_KEY_3 -> "3";
            case GLFW.GLFW_KEY_4 -> "4";
            case GLFW.GLFW_KEY_5 -> "5";
            case GLFW.GLFW_KEY_6 -> "6";
            case GLFW.GLFW_KEY_7 -> "7";
            case GLFW.GLFW_KEY_8 -> "8";
            case GLFW.GLFW_KEY_9 -> "9";
            case GLFW.GLFW_KEY_0 -> "0";
            case GLFW.GLFW_KEY_F1 -> "F1";
            case GLFW.GLFW_KEY_F2 -> "F2";
            case GLFW.GLFW_KEY_F3 -> "F3";
            case GLFW.GLFW_KEY_F4 -> "F4";
            case GLFW.GLFW_KEY_F5 -> "F5";
            case GLFW.GLFW_KEY_F6 -> "F6";
            case GLFW.GLFW_KEY_F7 -> "F7";
            case GLFW.GLFW_KEY_F8 -> "F8";
            case GLFW.GLFW_KEY_F9 -> "F9";
            case GLFW.GLFW_KEY_F10 -> "F10";
            case GLFW.GLFW_KEY_F11 -> "F11";
            case GLFW.GLFW_KEY_F12 -> "F12";
            case GLFW.GLFW_KEY_LEFT_BRACKET -> "[";
            case GLFW.GLFW_KEY_RIGHT_BRACKET -> "]";
            case GLFW.GLFW_KEY_BACKSLASH -> "\"";
            case GLFW.GLFW_KEY_MINUS -> "-";
            case GLFW.GLFW_KEY_EQUAL -> "=";
            case GLFW.GLFW_KEY_SEMICOLON -> ";";
            case GLFW.GLFW_KEY_APOSTROPHE -> "'";
            case GLFW.GLFW_KEY_COMMA -> ",";
            case GLFW.GLFW_KEY_PERIOD -> ".";
            case GLFW.GLFW_KEY_SLASH -> "/";
            case GLFW.GLFW_KEY_RIGHT_SHIFT -> "RShift";
            case GLFW.GLFW_KEY_RIGHT_CONTROL -> "RCtrl";
            case GLFW.GLFW_KEY_RIGHT_ALT -> "RAlt";
            case GLFW.GLFW_KEY_UP -> "Up";
            case GLFW.GLFW_KEY_DOWN -> "Down";
            case GLFW.GLFW_KEY_LEFT -> "Left";
            case GLFW.GLFW_KEY_RIGHT -> "Right";
            case GLFW.GLFW_KEY_PRINT_SCREEN -> "PrntScrn";
            case GLFW.GLFW_KEY_SCROLL_LOCK -> "ScrlLock";
            case GLFW.GLFW_KEY_PAUSE -> "PauseBrk";
            case GLFW.GLFW_KEY_INSERT -> "Insrt";
            case GLFW.GLFW_KEY_HOME -> "Home";
            case GLFW.GLFW_KEY_END -> "End";
            case GLFW.GLFW_KEY_PAGE_DOWN -> "PgDown";
            case GLFW.GLFW_KEY_NUM_LOCK -> "NumLock";
            case GLFW.GLFW_KEY_KP_MULTIPLY -> "num*";
            case GLFW.GLFW_KEY_KP_7 -> "num7";
            case GLFW.GLFW_KEY_KP_8 -> "num8";
            case GLFW.GLFW_KEY_KP_9 -> "num9";
            case GLFW.GLFW_KEY_KP_ADD -> "num+";
            case GLFW.GLFW_KEY_KP_DIVIDE -> "num/";
            case GLFW.GLFW_KEY_KP_4 -> "num4";
            case GLFW.GLFW_KEY_KP_5 -> "num5";
            case GLFW.GLFW_KEY_KP_6 -> "num6";
            case GLFW.GLFW_KEY_KP_1 -> "num1";
            case GLFW.GLFW_KEY_KP_2 -> "num2";
            case GLFW.GLFW_KEY_KP_3 -> "num3";
            case GLFW.GLFW_KEY_KP_0 -> "num0";
            case GLFW.GLFW_KEY_KP_DECIMAL -> "num.";
            case GLFW.GLFW_MOUSE_BUTTON_3 -> "MB3";
            case GLFW.GLFW_MOUSE_BUTTON_4 -> "MB4";
            case GLFW.GLFW_MOUSE_BUTTON_5 -> "MB5";
            case GLFW.GLFW_MOUSE_BUTTON_6 -> "MB6";
            case GLFW.GLFW_KEY_DELETE -> "None";
            default -> "None";
        };
    }

}
