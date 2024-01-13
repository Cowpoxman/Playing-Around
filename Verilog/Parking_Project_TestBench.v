`timescale 1ns / 1ps  

module ParkingTestbench;

  // Inputs
  reg entrance_sensor;
  reg exit_sensor;
  reg clock;
  reg reset;
  reg [3:0] password_input;

  // Outputs
  wire entrance_gate;
  wire exit_gate;
  wire [6:0] display;

  // We are instantiating the Parking module here
  Parking uut (
    .entrance_sensor(entrance_sensor),
    .exit_sensor(exit_sensor),
    .clock(clock),
    .reset(reset),
    .password_input(password_input),
    .entrance_gate(entrance_gate),
    .exit_gate(exit_gate),
    .display(display)
  );

  // Initial stimulus
  initial begin
    // Initialize inputs
    entrance_sensor = 0;
    exit_sensor = 0;
    clock = 0;
    reset = 1;
    password_input = 4'b0000;

    // Apply reset
    #5 reset = 0;

    // We are now simulating some basic test case  scenarios
    // Scenario 1: Car approaches, enters correct password, and exits
    #10 entrance_sensor = 1;
    #5 entrance_sensor = 0;
    #5 password_input = 4'b1101;  // Correct password
    #10 password_input = 4'b0000; // Reset password
    #10 exit_sensor = 1;          // Car exits
    #5 exit_sensor = 0;

    // Scenario 2: Car approaches, enters incorrect password, timeout
    #10 entrance_sensor = 1;
    #5 entrance_sensor = 0;
    #5 password_input = 4'b1010;  // Incorrect password
    #100;  // Wait for timeout

    

    // Finish simulation
    #10 $finish;
  end

  // Clock generation
  always #5 clock = ~clock;

endmodule
