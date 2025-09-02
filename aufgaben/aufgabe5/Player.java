
public class Player {

    private String nickname;
    private World world = null;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return this.nickname;
    }

    public void JoinWorld(World world) {
        this.world = world;
        this.world.join(this);
    }

}
