import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankClient extends Frame{
	public static void main(String[] args){
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	public void launchFrame(){
		setTitle("TankAer");
		setBounds(100, 100, 800, 600);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}	
		});
		setResizable(false);
	}
}
