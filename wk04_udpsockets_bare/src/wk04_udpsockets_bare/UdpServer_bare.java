package wk04_udpsockets_bare;

import java.io.*;
import java.net.*;
import java.util.*;

public class UdpServer_bare {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Starting....");
		DatagramSocket socket = new DatagramSocket( 17777 );
		byte[] buf = new byte[256];
	    DatagramPacket packet = new DatagramPacket( buf, buf.length );
	    System.out.println("Waiting for packet...");
	    socket.receive( packet );
	    System.out.println("Message received from " + packet.getAddress() + "/ " + packet.getPort() + "/ length of:" + packet.getLength());
	    String message = new String(packet.getData());
	    System.out.println("Message received: " + message);
	    
	    

		
		
		// send hello
		String msg = "Heya";
		byte[] bufsend = msg.getBytes();	// we need raw bytes
		DatagramPacket packetSend = new DatagramPacket( bufsend, bufsend.length, packet.getAddress(), packet.getPort() );
		
		socket.send( packetSend );
    
		System.out.println("Message sent");

	    //TODO: show properties of packet (port, IP addres, ...), retrieve and show message
	    socket.close();
	}
}

