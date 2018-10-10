package me.eccentric_nz.profession;

import org.bukkit.ChatColor;

import java.util.HashMap;

public class Constants {

    public static HashMap<String, String> npm() {
        // permission messages
        HashMap NO_PERMS_MESSAGE = new HashMap<String, String>();
        NO_PERMS_MESSAGE.put("EN", "You do not have permission to change villager professions");
        NO_PERMS_MESSAGE.put("FR", "Vous n'avez pas la permission de changer les occupations des villageois");
        NO_PERMS_MESSAGE.put("DE", "Sie haben keine berechtigung, um die berufe der dorfbewohner ändern");
        NO_PERMS_MESSAGE.put("ES", "Usted no tiene permiso para cambiar las profesiones de los habitantes del pueblo");
        return NO_PERMS_MESSAGE;
    }

    public static HashMap<String, String> nms() {
        // material messages
        HashMap NO_MATS_START = new HashMap<String, String>();
        NO_MATS_START.put("EN", "You do not have the right material to change the profession of this villager .\nTry:\n");
        NO_MATS_START.put("FR", "Vous n'avez pas le bon matériel pour changer la profession de ce villageois.\nEssayez:\n");
        NO_MATS_START.put("DE", "Sie haben nicht das richtige Material, um den Beruf des Dorfbewohner zu ändern.\nversuchen Sie:\n");
        NO_MATS_START.put("ES", "Usted no tiene el material correcto para cambiar de profesión este aldeano.\nPruebe:\n");
        return NO_MATS_START;
    }

    public static HashMap<String, String> tma() {
        // command too many arguments messages
        HashMap TOO_MANY_ARGS = new HashMap<String, String>();
        TOO_MANY_ARGS.put("EN", "There are too many command arguments!");
        TOO_MANY_ARGS.put("FR", "Il existe des arguments de commande trop nombreux!");
        TOO_MANY_ARGS.put("DE", "Zu viele argumente befehl!");
        TOO_MANY_ARGS.put("ES", "Hay argumentos del comando demasiados!");
        return TOO_MANY_ARGS;
    }

    public static HashMap<String, String> tfa() {
        // command too few arguments messages
        HashMap TOO_FEW_ARGS = new HashMap<String, String>();
        TOO_FEW_ARGS.put("EN", "There are not enough command arguments!");
        TOO_FEW_ARGS.put("FR", "Les arguments de la commande sont trop peu nombreux!");
        TOO_FEW_ARGS.put("DE", "Es gibt nicht genügend argumente befehl!");
        TOO_FEW_ARGS.put("ES", "El número de argumentos del comando es demasiado escasa!");
        return TOO_FEW_ARGS;
    }

    public static HashMap<String, String> nvv() {
        // command  not valid villager type messages
        HashMap NOT_VALID_VILLAGER = new HashMap<String, String>();
        NOT_VALID_VILLAGER.put("EN", "That is not a valid Villager type!\nTry:");
        NOT_VALID_VILLAGER.put("FR", "Ce n'est pas un type valide de Villager! Essayez:");
        NOT_VALID_VILLAGER.put("DE", "Das ist kein gültiger typ von Villager! versuchen Sie:");
        NOT_VALID_VILLAGER.put("ES", "Eso no es un tipo válido de Villager! Pruebe:");
        return NOT_VALID_VILLAGER;
    }

    public static HashMap<String, String> nvm() {
        // command not valid material type messages
        HashMap NOT_VALID_MATERIAL = new HashMap<String, String>();
        NOT_VALID_MATERIAL.put("EN", "That is not a valid Material!");
        NOT_VALID_MATERIAL.put("FR", "Ce n'est pas un matériau valide!");
        NOT_VALID_MATERIAL.put("DE", "Das ist keine gültige werkstoff!");
        NOT_VALID_MATERIAL.put("ES", "Eso no es un material válido!");
        return NOT_VALID_MATERIAL;
    }

    public static HashMap<String, String> ssm(ChatColor col, String str) {
        // profession set success messages
        HashMap SET_SUCCESS = new HashMap<String, String>();
        SET_SUCCESS.put("EN", "The villager was changed to a " + col + str);
        SET_SUCCESS.put("FR", "Le villageois a été changé en un " + col + str);
        SET_SUCCESS.put("DE", "Der dorfbewohner wurde zu einer " + col + str + ChatColor.WHITE + " geändert");
        SET_SUCCESS.put("ES", "El aldeano se cambiado a un " + col + str);
        return SET_SUCCESS;
    }

    public static HashMap<String, String> vms(String vil, String typ) {
        // profession set material messages
        HashMap MAT_SET_OK = new HashMap<String, String>();
        MAT_SET_OK.put("EN", "The " + vil + " material was set to " + typ);
        MAT_SET_OK.put("FR", "Le matériel des " + vil + " a été changé pour " + typ);
        MAT_SET_OK.put("DE", "Die " + vil + " material wurde auf " + typ + " ge�ndert");
        MAT_SET_OK.put("ES", "El material " + vil + " se cambiado a " + typ);
        return MAT_SET_OK;
    }

    public static HashMap<String, String> wnf() {
        // profession world not found messages
        HashMap WORLD_NOT_FOUND = new HashMap<String, String>();
        WORLD_NOT_FOUND.put("EN", "Could not find the specified world!");
        WORLD_NOT_FOUND.put("FR", "Impossible de trouver le monde spécifié!");
        WORLD_NOT_FOUND.put("DE", "Konnte nicht gefunden werden die angegebene Welt!");
        WORLD_NOT_FOUND.put("ES", "No se pudo encontrar el mundo especificado!");
        return WORLD_NOT_FOUND;
    }

    public static HashMap<String, String> ntf() {
        // argument should be true or false messages
        HashMap NOT_TRUE_FALSE = new HashMap<String, String>();
        NOT_TRUE_FALSE.put("EN", "The second command argument should be true or false!");
        NOT_TRUE_FALSE.put("FR", "L'argument deuxième commande devrait être vraie ou fausse!");
        NOT_TRUE_FALSE.put("DE", "Der zweite befehl Argument sollte wahr oder falsch sein!");
        NOT_TRUE_FALSE.put("ES", "El argumento segundo comando debe ser verdadero o falso!");
        return NOT_TRUE_FALSE;
    }

    public static HashMap<String, String> wds(String wor) {
        // profession toggled off messages
        HashMap WORLD_DISABLED = new HashMap<String, String>();
        WORLD_DISABLED.put("EN", "Profession has been disabled in " + wor);
        WORLD_DISABLED.put("FR", "Profession a été désactivé dans ");
        WORLD_DISABLED.put("DE", "Profession hat in " + wor + " wurde deaktiviert");
        WORLD_DISABLED.put("ES", "Profession ha sido desactivado en " + wor);
        return WORLD_DISABLED;
    }

    public static HashMap<String, String> wes(String wor) {
        // profession toggled on messages
        HashMap WORLD_ENABLED = new HashMap<String, String>();
        WORLD_ENABLED.put("EN", "Profession has been enabled in " + wor);
        WORLD_ENABLED.put("FR", "Profession a été activé dans " + wor);
        WORLD_ENABLED.put("DE", "Profession hat in " + wor + " aktivierten wurde");
        WORLD_ENABLED.put("ES", "Profession ha sido habilitada en " + wor);
        return WORLD_ENABLED;
    }

    public static HashMap<String, String> pna(String wor) {
        // profession not enabled messages
        HashMap NOT_ENABLED = new HashMap<String, String>();
        NOT_ENABLED.put("EN", "Profession is disabled in " + wor + ". Use /worldprof to enable it");
        NOT_ENABLED.put("FR", "Profession est désactivé dans " + wor + ". Utilisez / worldprof pour lui permettre");
        NOT_ENABLED.put("DE", "Profession wird in " + wor + " deaktiviert. Verwenden Sie /worldprof um es zu aktivieren");
        NOT_ENABLED.put("ES", "Profession está desactivado en " + wor + ". Utilice / worldprof para activarlo");
        return NOT_ENABLED;
    }

    public static HashMap<String, String> cen() {
        // consume config enabled messages
        HashMap CONSUME_ENABLE = new HashMap<String, String>();
        CONSUME_ENABLE.put("EN", "Consuming materials was enabled");
        CONSUME_ENABLE.put("FR", "La consommation de matériaux a été activée");
        CONSUME_ENABLE.put("DE", "Der konsum von materialien war aktiviert");
        CONSUME_ENABLE.put("ES", "El consumo de materiales se ha habilitado");
        return CONSUME_ENABLE;
    }

    public static HashMap<String, String> cds() {
        // consume config disabled messages
        HashMap CONSUME_DISABLE = new HashMap<String, String>();
        CONSUME_DISABLE.put("EN", "Consuming materials was disabled");
        CONSUME_DISABLE.put("FR", "La consommation de matériaux a été désactivé");
        CONSUME_DISABLE.put("DE", "Der konsum von materialien war deaktiviert");
        CONSUME_DISABLE.put("ES", "El consumo de materiales se ha desactivado");
        return CONSUME_DISABLE;
    }

    public static HashMap<String, String> men() {
        // message config enabled messages
        HashMap MESSAGE_ENABLE = new HashMap<String, String>();
        MESSAGE_ENABLE.put("EN", "Player messages were enabled");
        MESSAGE_ENABLE.put("FR", "Les messages du joueur ont été activés");
        MESSAGE_ENABLE.put("DE", "Spieler nachrichten wurden aktiviert");
        MESSAGE_ENABLE.put("ES", "Los mensajes del jugador fueron habilitados");
        return MESSAGE_ENABLE;
    }

    public static HashMap<String, String> mds() {
        // message config disabled messages
        HashMap MESSAGE_DISABLE = new HashMap<String, String>();
        MESSAGE_DISABLE.put("EN", "Player messages were disabled");
        MESSAGE_DISABLE.put("FR", "Les messages du joueur ont été désactivés");
        MESSAGE_DISABLE.put("DE", "Spieler nachrichten wurden deaktiviert");
        MESSAGE_DISABLE.put("ES", "Los mensajes del jugador fueron deshabilitados");
        return MESSAGE_DISABLE;
    }

    public static String NO_MATS_MESSAGE;
}
