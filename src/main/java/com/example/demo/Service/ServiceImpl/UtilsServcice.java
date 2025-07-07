package com.example.demo.Service.ServiceImpl;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UtilsServcice {

    public int getHora() {
        int hora = LocalDateTime.now().getHour();

        if (hora < 10)
            return 7;
        else if (hora >= 10 && hora < 13)
            return 10;
        else if (hora >= 13 && hora < 16)
            return 13;
        else if (hora >= 16 && hora < 19)
            return 16;
        else if (hora >= 19)
            return 19;

        return 0;
    }

    public boolean isSoleado(double temperatura, int intensidad, int probabilidad) {
        if (intensidad == 0 && temperatura >= 20)
            return true;
        return false;
    }

    public boolean isNublado(double temperatura, int intensidad, int probabilidad) {
        if (intensidad == 0 && temperatura < 20)
            return true;
        if (intensidad >= 1 && intensidad <= 3) {
            if (temperatura < 20 && probabilidad < 30)
                return true;
            if (temperatura > 20 && probabilidad < 30)
                return true;
        }
        return false;
    }

    public boolean isLluviaLigera(double temperatura, int intensidad, int probabilidad) {
        if (intensidad == 1 && probabilidad > 30)
            return true;
        return false;
    }

    public String getUrl(boolean esDeDia, double temperatura, int intensidad, int probabilidad) {
        if (intensidad == 0) {
            if (temperatura < 16)
                return esDeDia ? "/icons/clima/static/nublado.svg" : "/icons/clima/static/noche-nublada.svg";
            else
                return esDeDia ? "/icons/clima/static/day.svg" : "/icons/clima/static/night.svg";
        }

        if (intensidad >= 1 && intensidad <= 3) {
            if (esDeDia) {
                if (temperatura < 20) {
                    if (probabilidad < 30) {
                        switch (intensidad) {
                            case 1: return "/icons/clima/static/sol-nubladosuave.svg";
                            case 2: return "/icons/clima/static/sol-nublado.svg";
                            case 3: return "/icons/clima/static/sol-nubladofuerte.svg";
                        }
                    } else {
                        switch (intensidad) {
                            case 1: return "/icons/clima/static/garua.svg";
                            case 2: return "/icons/clima/static/lluviasuave-2.svg";
                            case 3: return "/icons/clima/static/lluvia-3.svg";
                        }
                    }
                } else {
                    switch (intensidad) {
                        case 1: return "/icons/clima/static/sol-lluviasuave-1.svg";
                        case 2: return "/icons/clima/static/massol-lluviasuave-2.svg";
                        case 3: return "/icons/clima/static/sol-lluviasuave-2.svg";
                    }
                }
            } else {
                if (probabilidad < 30) {
                    switch (intensidad) {
                        case 1: return "/icons/clima/static/noche-nubladasuave.svg";
                        case 2: return "/icons/clima/static/noche-nublada.svg";
                        case 3: return "/icons/clima/static/noche-nubladafuerte.svg";
                    }
                } else {
                    switch (intensidad) {
                        case 1: return "/icons/clima/static/garua.svg";
                        case 2: return "/icons/clima/static/lluviasuave-2.svg";
                        case 3: return "/icons/clima/static/lluvia-3.svg";
                    }
                }
            }
        }

        if (intensidad > 3)
            return "/icons/clima/static/tormentas.svg";

        return "/icons/clima/static/weather.svg";
    }

}
