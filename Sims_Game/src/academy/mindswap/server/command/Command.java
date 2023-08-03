package academy.mindswap.server.command;

import java.util.ArrayList;
import java.util.List;

public enum Command {
    QUIT("/quit", new QuitHandler()),
    PRINT_COMMAND("/print_command", new CommandPrint()),
    SLEEP("/sleep", new CommandSleep()),
    WAKEUP("/wakeup", new CommandWakeUP()),
    PRINT_STATISTIC("/statistic",new CommandStatistic()),
    NOT_FOUND("Command not found", new CommandNotFoundHandler()),
    LIST_ASSETS("/list_assents", new CommandAssets()),
    BUY_HOUSE("/buy_house", new CommandHouse()),
    BUY_CAR("/buy_car", new CommandCar()),
    WORK("/work", new CommandWork()),
    GYM("/gym", new CommandGym()),
    LEAVE_GYM("/leave_gym", new CommandLeaveGym()),
    FINISH_EATING("/finish_eating", new CommandFinishEating()),
    EAT("/eat", new CommandoEat());

    private String description;
    private CommandHandler handler;

    Command(String description, CommandHandler handler) {
        this.description = description;
        this.handler = handler;
    }

    public static Command getCommandFromDescription(String description) {
        for (Command command : values()) {
            if (description.equals(command.description)) {
                return command;
            }
        }
        return NOT_FOUND;
    }

    public CommandHandler getHandler() {
        return handler;
    }

    public static List<String> Description() {
        List<String> descriptio = new ArrayList<>();
        Command commands[] = Command.values();
       // Arrays.stream(commands).forEach(command -> command.description);
        for (Command command: commands){
            descriptio.add(command.description);
        }
        return descriptio;
    }
    public String getDescription(){
        return  description;
    }
}

