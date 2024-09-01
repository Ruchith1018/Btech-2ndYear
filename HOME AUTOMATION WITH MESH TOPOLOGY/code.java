package End;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


class HomeAutomation {
  public Map<String, Boolean> devices; // map of devices and their status (on/off)
  public Map<String, LinkedList<String>> graph; // adjacency list representation of graph
  public Map<String, ArrayList<String>> meshNetwork;

  public Map<String, Boolean> deviceStates;

  public HomeAutomation() {
    devices = new HashMap<>();
    graph = new HashMap<>();
    meshNetwork = new HashMap<>();
    deviceStates = new HashMap<>();
  }

  // adds a device to the home automation system
  public void addDevice(String deviceName) {
    devices.put(deviceName, false);
    graph.put(deviceName, new LinkedList<>());
    deviceStates.put(deviceName, false);
    System.out.println(deviceName+" Added to Home\n");
  }

  // adds a connection between two devices
  public void addConnection(String device1, String device2) {
    graph.get(device1).add(device2);
    graph.get(device2).add(device1);
    System.out.println("The "+device1+" is connected to "+device2+"\n");
    
  }

  // turns a device on
  public void turnOn(String deviceName) {
    devices.put(deviceName, true);
    deviceStates.put(deviceName, true);
  }

  // turns a device off
  public void turnOff(String deviceName) {
    devices.put(deviceName, false);
    deviceStates.put(deviceName, false);
  }
  public void setDeviceState(String device, boolean state) {
	    devices.put(device,state);
	    deviceStates.put(device, state);
	    if (state == true) {
	    	System.out.println("The "+device+" is set to True ");
	    	turnOn(device);
	    }
	    else if(state ==false) {
	    	System.out.println("The "+device+" is set to False ");
	    	turnOff(device);
	    }
	    
	  }
  public boolean getDeviceState(String device) {
	    return deviceStates.get(device);
	    
	  }
  public void propagateStateChange(String device) {
	    boolean state = getDeviceState(device);
	    ArrayList<String> connectedDevices = meshNetwork.get(device);
	    for (String connectedDevice : connectedDevices) {
	      setDeviceState(connectedDevice, state);
	      propagateStateChange(connectedDevice);
	    }
	  }
  public void printStatus() {
	    for (String device : meshNetwork.keySet()) {
	      String status = getDeviceState(device) ? "on" : "off";
	      System.out.println(device + ": " + status);
	    }
	  }

  // turns a group of devices on
  public void turnOnGroup(String deviceName) {
	  System.out.println("\nTurning on...\n");
    Queue<String> queue = new LinkedList<>();
    queue.add(deviceName);
    while (!queue.isEmpty()) {
      String currentDevice = queue.poll();
      if (!devices.get(currentDevice)) {
        devices.put(currentDevice, true);
        for (String neighbor : graph.get(currentDevice)) {
          queue.add(neighbor);
        }
      }
    }
  }

  // turns a group of devices off
  public void turnOffGroup(String deviceName) {
	  System.out.println("\nTurning off...\n");
    Queue<String> queue = new LinkedList<>();
    queue.add(deviceName);
    while (!queue.isEmpty()) {
      String currentDevice = queue.poll();
      if (devices.get(currentDevice)) {
        devices.put(currentDevice, false);
        for (String neighbor : graph.get(currentDevice)) {
          queue.add(neighbor);
        }
      }
    }
  }

  public static void main(String[] args) {
    HomeAutomation home = new HomeAutomation();  
    home.addDevice("Hall Sensor");
    home.addDevice("Kitchen Sensor");
    home.addDevice("Bedroom Sensor");
    home.addDevice("Hall Bar Light");
    home.addDevice("Hall Tv");
    home.addDevice("Kitchen Bulb");
    home.addDevice("Kitchen Exhaust Fan");
    home.addDevice("Bed Room TV");
    home.addDevice("Bed Room Light");
    home.addDevice("Bed Room AC");
    home.addConnection("Hall Bar Light", "Hall Tv");
    home.addConnection("Hall Tv", "Hall Sensor");
    home.addConnection("Hall Sensor", "Kitchen Sensor");
    home.addConnection("Kitchen Sensor", "Kitchen Bulb");
    home.addConnection("Kitchen Bulb", "Kitchen Exhaust Fan");
    home.addConnection("Kitchen Sensor","Bedroom Sensor");
    home.addConnection("Bedroom Sensor","Bed Room TV");
    home.addConnection("Bed Room Light","Bed Room TV");
    home.addConnection("Bed Room Light","Bed Room AC");
    home.addConnection("Kitchen Sensor","Hall Sensor");
    home.addConnection("Hall Bar Light", "Kitchen Sensor");
    home.addConnection("Kitchen Bulb", "Bed Room TV");
    home.addConnection("Kitchen Sensor", "Bed Room TV");
    home.addConnection("Kitchen Exhaust Fan", "Bed Room AC");
    home.addConnection("Bed Room AC", "Kitchen Bulb");
    home.addConnection("Hall Bar Light","Kitchen Bulb");
    home.addConnection("Bedroom Sensor","Bed Room Light");
    home.addConnection("Hall Sensor","Bedroom Sensor");
    home.turnOnGroup("Hall Tv");
    System.out.println(home.devices);
    home.turnOffGroup("Hall Sensor");
    System.out.println(home.devices);
    home.turnOn("Bed Room AC");
    System.out.println(home.devices);
    home.setDeviceState("Bed Room Light",false);
    home.getDeviceState("Bed Room Light");
    System.out.println(home.devices);
    home.printStatus();

  }
}
