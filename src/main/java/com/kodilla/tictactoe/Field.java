package com.kodilla.tictactoe;

public enum Field {

    CROSS("X"){
        @Override
        public String toString() {
            return "X";
        }
    },
    CIRCLE("O"){
        @Override
        public String toString() {
            return "O";
        }
    },
    NONE{
        @Override
        public String toString() {
            return " ";
        }
    };

    private String command;
    Field(String command) {
        this.command =command;
    }

    Field() {

    }

    public static Field Of(String command){
        for (Field choices : values()){
            if(choices.command.equals(command)){
                return choices;
            }
        }
        throw new IllegalArgumentException("Wrong move" + command);
    }
}
