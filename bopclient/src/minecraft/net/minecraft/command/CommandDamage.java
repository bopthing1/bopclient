package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class CommandDamage extends CommandBase {
  /**
   * Gets the name of the command
   */
  public String getCommandName() {
    return "damage";
  }

  /**
   * Return the required permission level for this command.
   */
  public int getRequiredPermissionLevel() {
    return 2;
  }

  /**
   * Gets the usage string for the command.
   */
  public String getCommandUsage(ICommandSender sender) {
    return "commands.damage.usage";
  }

  /**
   * Callback when the command is invoked
   */
  public void processCommand(ICommandSender sender, String[] args) throws CommandException {
	  
	if (args[0] == null) {
		IChatComponent component = new ChatComponentText("Failed to run :(");
		sender.addChatMessage(component);
	}
    EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
    entityplayer.setHealth(entityplayer.getHealth() - 2);

  }

  /**
   * Return whether the specified command parameter index is a username parameter.
   */
  public boolean isUsernameIndex(String[] args, int index) {
    return index == 0;
  }

  public List < String > addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
    return args.length == 1 ? getListOfStringsMatchingLastWord(args, MinecraftServer.getServer().getAllUsernames()) : null;
  }
}