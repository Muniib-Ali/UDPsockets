package wk04_udpsockets_bare;

import java.io.*;
import java.net.*;

public class UdpClient_bare {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		
		
		// send hello
		String msg = "Hello";
		byte[] buf = msg.getBytes();	// we need raw bytes
		InetAddress address = InetAddress.getByName( "127.0.0.1" );	// why getByName?
		DatagramPacket packetSend = new DatagramPacket( buf, buf.length, address, 17777 );
		
		System.out.println( "Press any key to send packet." ); System.in.read();	// simply waits for a key
		socket.send( packetSend );
		
		byte[] bufReceive = new byte[256];
	    DatagramPacket packet = new DatagramPacket( bufReceive, bufReceive.length );
	    System.out.println("Waiting for reply...");
	    socket.receive( packet );
	    System.out.println("Reply received from " + packet.getAddress() + "/ " + packet.getPort() + "/ length of:" + packet.getLength());
	    String message = new String(packet.getData());
	    System.out.println("Reply received: " + message);
	    
        socket.close();
        System.out.println( "Done." );
	}
}
