// verilog
module Parking(
  input wire entrance_sensor,
  input wire exit_sensor,
  input wire clock,
  input wire reset,
  input wire [3:0] password_input,
  output wire entrance_gate,
  output wire exit_gate,
  output wire [6:0] display
);
  reg [2:0] state;
//   List of possible states for the parking system
  parameter IDLE = 3'b000, PASSWORD_ENTRY = 3'b001, GATE_OPEN = 3'b010;

//   Default password has been set to 25
  reg [3:0] password = 4'b1101;

// Setting a time out for password entry
  parameter TIMEOUT_LIMIT = 16'd10000; 
  reg [15:0] timeout_counter;

// car inside flag will help us to track cars movement accross the gate 
  reg car_inside;
  reg car_request;

  // Output logic for gates
  assign entrance_gate = (state == GATE_OPEN);
  assign exit_gate = (state == GATE_OPEN && !car_inside);

  // Display logic
  always @* begin
    case (state)
      PASSWORD_ENTRY: display = password_input;
      default: display = 7'b1111111; // display string of ones on screen by default
    endcase
  end

  always @(posedge clock or posedge reset) begin
    if (reset) begin
        // reset system logic
      state <= IDLE;
      car_inside <= 0;
      car_request <= 0;
      timeout_counter <= 0;
    end
    else begin
      case (state)
        IDLE: begin
            // idle is the waiting state of our parking system
          if (entrance_sensor && !car_inside) begin
            state <= PASSWORD_ENTRY;
            car_request <= 1;
          end
        end

        PASSWORD_ENTRY: begin
            // waits for password to be entered 
          if (car_request) begin
            if (password_input == password) begin
              state <= GATE_OPEN;
              car_inside <= 1; // flags the car as in the process of being entered
              timeout_counter <= 0;
            end
            else if (timeout_counter >= TIMEOUT_LIMIT) begin
              state <= IDLE;
              car_request <= 0;
            end
            else begin
              timeout_counter <= timeout_counter + 1;
            end
          end
        end

        GATE_OPEN: begin
          if (exit_sensor && car_inside) begin
            state <= IDLE;
            car_inside <= 0;
          end
        end

// The mechanical logic for the gate could check if it is in the GATE_OPEN state to open the
// gate and close the gate if in IDLE state
        
      endcase
    end
  end

endmodule
