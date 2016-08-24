package net.spacegeek224.conversation.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.spacegeek224.conversation.ConversationPlugin;

public class CommandMessage implements CommandExecutor {

	private ConversationPlugin p;
	
	public CommandMessage(ConversationPlugin p) {
		
		this.p = p;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeUTF("BungeeCord");
			out.writeUTF("Message");
			out.writeUTF(player.getName());
			StringBuilder builder = new StringBuilder();
			for (int i=1;i<args.length;i++) {
			    if (builder.length() > 0) {
			        builder.append(" ");
			    }
			    builder.append(args[i]);
			}
			out.writeUTF(builder.toString());

			// If you don't care about the player // Player player =
			// Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
			// Else, specify them
//			Player plr = Bukkit.getPlayerExact("spacegeek224");
//
			player.sendPluginMessage(p, "BungeeCord", out.toByteArray());
			// Here we need to give items to our player
		} else {
			
		}

		// If the player (or console) uses our command correct, we can return
		// true
		return true;
	}
}
