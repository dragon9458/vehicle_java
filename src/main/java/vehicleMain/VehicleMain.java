package vehicleMain;

import beans.Parameters;


public class VehicleMain {
	
	public static void main(String args[]) {
		startVehicle();
	}
	
	/**
	 * vehicle程序开始
	 */
	public static void startVehicle() {
		//创建唯一实例
		Parameters param = Parameters.getInstance();
		//启动摄像头

		
	
	}
	
	/**
	 * Initialize the contents of the frame. 
	 */
	private void initialize(){
		//创建唯一实例
		/*
		Parameters param = Parameters.getInstance();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u62CD\u7167");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//静态变量设置为1，从而按下按钮时会停止摄像头的调用
				param.setFlag(1);
			}
		});
		btnNewButton.setBounds(33, 13, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		label = new JLabel("");
		label.setBounds(0, 0, 800, 450);
		frame.getContentPane().add(label);	
		*/
	}
}
