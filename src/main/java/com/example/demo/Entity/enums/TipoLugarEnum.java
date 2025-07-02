package com.example.demo.Entity.enums;

import java.util.Map;

public class TipoLugarEnum {

    public static final int Abierto = 1;
    public static final int Cerrado = 2;

    private static final Map<Integer, String> TipoLugar = Map.of(
            Abierto, "Campo Abierto",
            Cerrado, "Campo Cerrado"
    );

    public static String getTipoLugar(int tipo) {
        return TipoLugar.getOrDefault(tipo, "Campo Abierto");
    }

}