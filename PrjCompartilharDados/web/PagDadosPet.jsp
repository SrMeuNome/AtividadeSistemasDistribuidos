<%-- 
    Document   : PagDadosPet
    Created on : 23/03/2021, 23:09:21
    Author     : SrMeuNome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <h:form>
                <h:panelGrid columns="2" styleClass="gridCampos">
                    <h:outputLabel for="txtNome" value="Nome:" />
                    <h:inputText id="txtNome" value="#{beanArq.pet.nome}" />
                    <h:outputLabel for="txtEspecie" value="Especie:" />
                    <h:inputText id="txtEspecie" value="#{beanArq.pet.especie}" />
                    <h:outputLabel for="txtRaca" value="Raca:" />
                    <h:inputText id="txtRaca" value="#{beanArq.pet.raca}" />
                    <h:outputLabel for="txtDataNasc" value="Data Nascimento:" />
                    <h:inputText id="txtDataNasc" value="#{beanArq.pet.data_nascimento}" />
                    <h:outputLabel for="txtPorte" value="Porte:" />
                    <h:inputText id="txtPorte" value="#{beanArq.pet.porte}" />
                    
                    <h:commandButton value="Gravar" action="#{beanArq.gravar()}" />
                </h:panelGrid>
                
                <h:panelGrid columns="2" styleClass="gridConsulta">
                    <h:selectOneListbox value="#{beanArq.nomeArquivo}">
                        <f:selectItems value="#{beanArq.arquivos}" var="arq"
                                      itemLabel="#{arq}" itemValue="#{arq}" />
                    </h:selectOneListbox>
                    
                    <h:commandButton value="Mostrar Conteudo" action="#{beanArq.listar()}" />
                </h:panelGrid>
                
                <h:panelGrid columns="2" styleClass="gridTabela">
                    <h:dataTable var="arq" value="#{beanArq.lstPet}">
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="NOME" />
                            </f:facet>
                            <h:outputText value="#{arq.nome}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="ESPECIE" />
                            </f:facet>
                            <h:outputText value="#{arq.especie}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="RAÇA" />
                            </f:facet>
                            <h:outputText value="#{arq.raca}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="PORTE" />
                            </f:facet>
                            <h:outputText value="#{arq.porte}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="DATA NASCIMENTO" />
                            </f:facet>
                            <h:outputText value="#{arq.data_nascimento}" />
                        </h:column>
                    </h:dataTable>
                </h:panelGrid>
            </h:form>
        </body>
    </html>
</f:view>
