package net.rimaki.emotax;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.command.data.CommandEnum;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.command.tree.ParamList;
import cn.nukkit.command.utils.CommandLogger;

// Plugind Stuff
import net.rimaki.emotax.EmotaXPlugin;

import java.util.Locale;
import java.util.Map;

public class EmotaXCommand extends PluginCommand<EmotaXPlugin> {
    String placeholdcmd = EmotaXPlugin.INSTANCE.getConfig().getString("Placeholder", "[EmotaX]");
    public EmotaXCommand() {
        // init Supper Command
        super("emotax", "emotax.emotaxcommamd.description", EmotaXPlugin.INSTANCE);
        this.setAliases(new String[]{"EmotaX"});

        //Perm Set For Permission Plugins
        this.setPermission("emotax.command");

        //Clear to prevent bug
        this.getCommandParameters().clear();

        this.getCommandParameters().put("version", new CommandParameter[]{
                CommandParameter.newEnum("pluginver", false, new CommandEnum("showpluginver", "version")),
        });
        this.getCommandParameters().put("list", new CommandParameter[]{
                CommandParameter.newEnum("emotelisting", false, new CommandEnum("showemotelist", "list")),
        });
        this.getCommandParameters().put("reload", new CommandParameter[]{
                CommandParameter.newEnum("configreloading", false, new CommandEnum("configreload", "reload")),
        });
        this.enableParamTree();
    }
    private void failed(CommandSender sender) {
        sender.sendMessage(placeholdcmd + " You didn't have permission to run this");
    }
    public int execute(CommandSender sender, String commandLabel, Map.Entry<String, ParamList> result, CommandLogger log) {
        ParamList args = result.getValue();
        String key = result.getKey();
        Player player = sender.asPlayer();
        switch (key) {
            case "version" -> {
                if (!sender.hasPermission("emotax.commamd.version"))
                    failed(sender);
                else
                    sender.sendMessage(placeholdcmd + " You're Running EmotaX : " + EmotaXPlugin.INSTANCE.plver + "\n Made by : " + EmotaXPlugin.INSTANCE.plauthors);
            }
            case "list" -> {
                if (!sender.hasPermission("emotax.commamd.list"))
                    failed(sender);
                else
                    sender.sendMessage(placeholdcmd + " Notting Here Lol (Not Implement Yet)");
            }
            case "reload" -> {
                if (!sender.hasPermission("emotax.command.reload"))
                    failed(sender);
                else
                    EmotaXPlugin.INSTANCE.reloadConfig();
                    sender.sendMessage(placeholdcmd + " EmotaX Is Reloaded Yay!");
            }
            default -> {
                // PAIN
                StringBuilder typed = new StringBuilder(key);
                for (int i = 0; i < args.size(); i++) {
                    typed.append(" ").append(args.getResult(i).toString());
                }
                sender.sendMessage(placeholdcmd + " Unknown Command " + typed);
                return 0;
            }
        }
        // Why lol its only allow 0 and 1
        return 1;
    }
}
