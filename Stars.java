package main;

public class Stars {
    public static void main(String args[]) {
        Stars.triangle3();
    }

    public static void square1() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = 1; rowNum <= colTotal; rowNum++) {
            for (int colNum = 1; colNum <= rowsTotal; colNum++) {
                System.out.print("*");
                if (colNum != 7) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void square2() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = 1; rowNum <= colTotal; rowNum++) {
            for (int colNum = 1; colNum <= rowsTotal; colNum++) {
                if (rowNum == 1 || rowNum == 7 || colNum == 1 || colNum == 7) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                if (colNum != 7) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void triangle3() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = 1; rowNum <= colTotal; rowNum++) {
            for (int colNum = 1; colNum <= colTotal; colNum++) {
                if (rowNum == 1 && colNum != 7) {
                    System.out.print("* ");
                } else if (colNum == 1) {
                    System.out.print("*");
                } else if (((rowsTotal - rowNum + 1) == colNum) && colNum != 7) {
                    System.out.print(" * ");
                } else if (colNum == 7 && rowNum == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("  ");
                }
                if (colNum != colTotal) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void triangle4() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = rowsTotal; rowNum > 0; rowNum--) {
            for (int colNum = colTotal; colNum > 0; colNum--) {
                if (rowNum == 1 && colNum != 7) {
                    System.out.print(" *");
                } else if (colNum == 7) {
                    System.out.print("*");
                } else if (rowNum == colNum && colNum != 7) {
                    System.out.print("* ");
                } else if (colNum == 7 && rowNum == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("  ");
                }
                if (colNum != 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void triangle5() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = rowsTotal; rowNum > 0; rowNum--) {
            for (int colNum = colTotal; colNum > 0; colNum--) {
                if (rowNum == 1 && colNum != 7) {
                    System.out.print(" *");
                } else if (colNum == 1) {
                    System.out.print("*");
                } else if (((rowsTotal - rowNum + 1) == colNum) && colNum != 7) {
                    System.out.print("* ");
                } else if (colNum == 7 && rowNum == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("  ");
                }
                if (colNum != 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void triangle6() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = rowsTotal; rowNum > 0; rowNum--) {
            for (int colNum = colTotal; colNum > 0; colNum--) {
                if (rowNum == 7 && colNum != 7) {
                    System.out.print(" *");
                } else if (colNum == 1) {
                    System.out.print("*");
                } else if (rowNum == colNum && colNum != 7) {
                    System.out.print("* ");
                } else if (colNum == 7 && rowNum == 7) {
                    System.out.print("*");
                } else {
                    System.out.print("  ");
                }
                if (colNum != 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void x() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = 1; rowNum <= colTotal; rowNum++) {
            for (int colNum = 1; colNum <= rowsTotal; colNum++) {
                if (((colTotal - colNum + 1) == rowNum) || (colNum == rowNum)) {
                    if (colNum > 4) {
                        System.out.print("  *");
                    } else {
                        System.out.print("*");
                    }
                } else if (colNum != 7) {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void triangle8() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = 1; rowNum <= colTotal; rowNum++) {
            if (rowNum <= 4) {
                for (int colNum = 1; colNum <= rowsTotal; colNum++) {
                    if (rowNum == 1 && colNum != 1 && colNum != 7) {
                        System.out.print(" * ");
                    } else if (rowNum == 1 && colNum == 1 ) {
                        System.out.print("* ");
                    } else if (rowNum == 1 && colNum == 7 ) {
                        System.out.print(" *");
                    }
                    else if (((colTotal - colNum + 1) == rowNum) || (colNum == rowNum)) {
                        if (colNum > 4) {
                            System.out.print("  *");
                        } else {
                            System.out.print("*");
                        }
                    } else if (colNum != 7) {
                        System.out.print("   ");
                    }
                }
            } else {
                System.out.println("                ");
            }
            System.out.println();
        }
    }

    public static void triangle9() {
        int rowsTotal = 7;
        int colTotal = 7;
        for (int rowNum = 1; rowNum <= rowsTotal; rowNum++) {
            if (rowNum >=4) {
                for (int colNum = 1; colNum <= colTotal; colNum++) {
                    if (rowNum == 7 && colNum != 1 && colNum != 7) {
                        System.out.print(" * ");
                    } else if (rowNum == 7 && colNum == 1 ) {
                        System.out.print("* ");
                    } else if (rowNum == 7) {
                        System.out.print(" *");
                    }
                    else if (((colTotal - colNum + 1) == rowNum) || (colNum == rowNum)) {
                        if (colNum > 4) {
                            System.out.print("  *");
                        } else {
                            System.out.print("*");
                        }
                    } else if (colNum != 7) {
                        System.out.print("   ");
                    }
                }
            } else {
                System.out.println("                ");
            }
            System.out.println();
        }
    }
}
