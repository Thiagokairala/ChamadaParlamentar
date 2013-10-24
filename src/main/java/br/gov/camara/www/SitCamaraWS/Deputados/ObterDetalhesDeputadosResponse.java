/**
 * ObterDetalhesDeputadosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.camara.www.SitCamaraWS.Deputados;

public class ObterDetalhesDeputadosResponse  implements java.io.Serializable {
    private br.gov.camara.www.SitCamaraWS.Deputados.ObterDetalhesDeputadosResponseObterDetalhesDeputadosResult obterDetalhesDeputadosResult;

    public ObterDetalhesDeputadosResponse() {
    }

    public ObterDetalhesDeputadosResponse(
           br.gov.camara.www.SitCamaraWS.Deputados.ObterDetalhesDeputadosResponseObterDetalhesDeputadosResult obterDetalhesDeputadosResult) {
           this.obterDetalhesDeputadosResult = obterDetalhesDeputadosResult;
    }


    /**
     * Gets the obterDetalhesDeputadosResult value for this ObterDetalhesDeputadosResponse.
     * 
     * @return obterDetalhesDeputadosResult
     */
    public br.gov.camara.www.SitCamaraWS.Deputados.ObterDetalhesDeputadosResponseObterDetalhesDeputadosResult getObterDetalhesDeputadosResult() {
        return obterDetalhesDeputadosResult;
    }


    /**
     * Sets the obterDetalhesDeputadosResult value for this ObterDetalhesDeputadosResponse.
     * 
     * @param obterDetalhesDeputadosResult
     */
    public void setObterDetalhesDeputadosResult(br.gov.camara.www.SitCamaraWS.Deputados.ObterDetalhesDeputadosResponseObterDetalhesDeputadosResult obterDetalhesDeputadosResult) {
        this.obterDetalhesDeputadosResult = obterDetalhesDeputadosResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObterDetalhesDeputadosResponse)) return false;
        ObterDetalhesDeputadosResponse other = (ObterDetalhesDeputadosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obterDetalhesDeputadosResult==null && other.getObterDetalhesDeputadosResult()==null) || 
             (this.obterDetalhesDeputadosResult!=null &&
              this.obterDetalhesDeputadosResult.equals(other.getObterDetalhesDeputadosResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getObterDetalhesDeputadosResult() != null) {
            _hashCode += getObterDetalhesDeputadosResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObterDetalhesDeputadosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.camara.gov.br/SitCamaraWS/Deputados", ">ObterDetalhesDeputadosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obterDetalhesDeputadosResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.camara.gov.br/SitCamaraWS/Deputados", "ObterDetalhesDeputadosResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.camara.gov.br/SitCamaraWS/Deputados", ">>ObterDetalhesDeputadosResponse>ObterDetalhesDeputadosResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
