
import java.util.ArrayList;

public class Player {

    private static int playerCount = 0;
    private final String nickname;
    private final String id;
    private World world = null;
    private final ArrayList<Block> inventory;
    private Tool tool = new Fists();

    // Die Richtung in der der Spieler schaut. Wichtig um zu entscheiden welchen 
    // Block man abbaut.
    private Direction direction = Direction.TOP;

    public Player(String nickname) {
        Player.playerCount++;
        this.id = "Player " + Player.playerCount;
        this.nickname = nickname;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return this.nickname;
    }

    public String getId() {
        return this.id;
    }

    public void JoinWorld(World world) {
        this.world = world;
        this.world.spawn(this);
    }

    public boolean move(Direction direction) {
        return this.world.movePlayer(this.id, direction);
    }

    public void turn(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Tool getTool() {
        return this.tool;
    }

    public void selectTool(Tool tool) {
        this.tool = tool;
    }

    public Block showBlock(Direction direction) {
        return this.world.showNextBlock(this.id, direction);
    }

    public boolean collectBlock(Direction direction) {
        Block block = this.world.collectBlock(this, direction);

        if(block == null) {
            return false;
        }

        this.inventory.add(block);

        return true;

    }

}
