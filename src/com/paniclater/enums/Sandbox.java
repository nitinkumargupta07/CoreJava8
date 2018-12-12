package com.paniclater.enums;

public class Sandbox {
    public enum E {
        VALUE {
            @Override
            public String toString() {
                return "I'm the value";
            }
        };

        @Override
        public String toString() {
            return "I'm the enum";
        }
    }
    public static void main(String[] args) {
        System.out.println(E.VALUE.toString());
    	System.out.println(E.VALUE);
    }
    //cannot inherit from final 
    public static  class C {
        @Override
        public String toString() {
            return "I'm a C";
        }
    }

    public static void main11(String[] args) {
        System.out.println(new C() {
            @Override
            public String toString() {
                return "I'm anonymous";
            }
        });
    }
}