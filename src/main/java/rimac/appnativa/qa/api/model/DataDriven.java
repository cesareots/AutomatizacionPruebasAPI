package rimac.appnativa.qa.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataDriven {

    private String codigo;
    private List<Map<String, Object>> listEndPoint;

    public DataDriven() {
        this.listEndPoint = new ArrayList<Map<String, Object>>();
        //Map<String, Object> map = new LinkedHashMap<String, Object>();
        //listEndPoint.add(map);
    }

    public DataDriven(String codigo) {
        this.codigo = codigo;
        this.listEndPoint = new ArrayList<Map<String, Object>>();
    }

    public String getCodigo() {
        return codigo;
    }

    /*public void setCodigo(String codigo) {
        this.codigo = codigo;
    }*/

    public List<Map<String, Object>> getListEndPoint() {
        return listEndPoint;
    }

    /*public void setListEndPoint(List<Map<String, Object>> listEndPoint) {
        this.listEndPoint = listEndPoint;
    }*/

    public void addMap(Map<String, Object> map) {
        this.listEndPoint.add(map);
    }
}
