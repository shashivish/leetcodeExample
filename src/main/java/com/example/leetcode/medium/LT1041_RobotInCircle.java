package com.example.leetcode.medium;

public class LT1041_RobotInCircle {

    public static void main(String[] args) {

        String instruction = "GGLLRRGG";
        LT1041_RobotInCircle t = new LT1041_RobotInCircle();
        boolean result = t.isRobotBounded(instruction);
        System.out.println("Result " + result);
    }


    public boolean isRobotBounded(String instructions) {

        int facingX = 0;
        int facingY = 1;
        int x = 0;
        int y = 0;


        for (int index = 0; index < instructions.length(); index++) {
            String c = String.valueOf(instructions.charAt(index));

            if (c.equalsIgnoreCase("G")) {
                x = x + facingX;
                y = y + facingY;
            } else if (c.equalsIgnoreCase("L")) {
                int tmp = facingX;
                facingX = -1 * facingY;
                facingY = tmp;
            } else if (c.equalsIgnoreCase("R")) {
                int tmp = facingX;
                facingX = facingY;
                facingY = -1 * tmp;
            }

            // System.out.println("c>>" + c + "  x>>" + x + " y >>" +y+" facingX>> " + facingX + " facingY>> "+ facingY  );

        }

        if (x == 0 && y == 0)
            return true;

        if (facingX == 0 && facingY == 1)
            return false;

        return true;

    }
}
