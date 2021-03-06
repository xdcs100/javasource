package com.java.net.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	private DatagramSocket ds;
	public Send(DatagramSocket ds){
		this.ds =ds;
	}
	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = bufr.readLine()) != null) {

				byte[] buf = line.getBytes();

				/*
				 * 192.168.1.0 是网段
				 * 192.168.1.255 是网波
				 * 发给192.168.1.255就是发给1-254
				 */
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 9999);
				ds.send(dp);

				if ("886".equals(line)) {
					break;
				}

			} 
			ds.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
