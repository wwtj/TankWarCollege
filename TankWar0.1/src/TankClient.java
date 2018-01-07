import java.awt.Frame;


public class TankClient extends Frame{
	public static void main(String[] args){
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	public void launchFrame(){
		setBounds(100, 100, 800, 600);
		setVisible(true);
	}
}
