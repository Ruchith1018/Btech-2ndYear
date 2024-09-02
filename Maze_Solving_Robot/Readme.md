# Maze Solving Robot

## Project Overview

This repository contains the code and resources for the "Maze Solving Robot" project. The project demonstrates how to implement a robot that can navigate and solve a maze using the Robot Operating System (ROS) and Python. The robot is designed to autonomously find its way through a maze by employing various algorithms and techniques.

## Technologies Used

- **Robot Operating System (ROS)**
- **Python**

## Project Structure

- `src/`: Python scripts and ROS nodes for controlling the robot and implementing the maze-solving algorithms.
- `launch/`: ROS launch files to start the various nodes required for the project.
- `config/`: Configuration files for ROS parameters and robot settings.
- `scripts/`: Auxiliary scripts for setting up the environment and running experiments.
- `docs/`: Documentation related to the project, including setup instructions and usage guidelines.

## Files

- `maze_solver_node.py`: ROS node implementing the maze-solving algorithm.
- `robot_controller.py`: ROS node for controlling the robot's movements.
- `maze_map.yaml`: Configuration file defining the maze layout.
- `robot_launch.launch`: ROS launch file to start the maze-solving and robot control nodes.

## Installation

To get started with this project, follow these steps:

1. **Install ROS**: Follow the official [ROS installation guide](http://wiki.ros.org/ROS/Installation) for your operating system.
2. **Clone the Repository**: 
    ```bash
    git clone https://github.com/Ruchith1018/Btech-2ndYear.git
    ```
3. **Setup Workspace**:
    - Navigate to the `Maze_Solving_Robot` directory and build the ROS workspace.
    - Source the ROS environment and build the package:
      ```bash
      cd ~/catkin_ws
      catkin_make
      source devel/setup.bash
      ```

## Usage

1. **Launch the Maze Solver**:
    ```bash
    roslaunch maze_solver robot_launch.launch
    ```
2. **Monitor the Robot**: Use ROS tools such as `rviz` or `rostopic` to monitor the robot's progress and debug any issues.

## Results

The `docs/` directory contains screenshots and logs demonstrating the robot solving various maze configurations. These results illustrate the effectiveness of the implemented algorithms and the robot's navigation capabilities.

## Contributing

Contributions to this project are welcome. If you have suggestions or improvements, please create a pull request or open an issue.

## Contact

For any inquiries or further information, please contact:

- **Name**: Ruchith
- **Email**: bl.ruchith@gmail.com
- **GitHub**: [Ruchith1018](https://github.com/Ruchith1018)



