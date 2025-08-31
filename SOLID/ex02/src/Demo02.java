public class Demo02 {
    public static void main(String[] args) {
        Player player = new Player(new SimpleDecoder(), new ConsolePlayerUI());
        player.play(new byte[]{1,2,3,4});

        player.play(new byte[]{10,20,30});
    }
}
