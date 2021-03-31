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
            <h1>Consulta de Produtos</h1>
            <h:form>                
                <h:panelGrid columns="2" styleClass="gridConsulta">
                    <h:selectOneListbox value="#{beanArq.nomeArquivo}">
                        <f:selectItems value="#{beanArq.arquivos}" var="arq"
                                      itemLabel="#{arq}" itemValue="#{arq}" />
                    </h:selectOneListbox>
                    
                    <h:commandButton value="Mostrar Conteudo" action="#{beanArq.listar()}" />
                </h:panelGrid>
                
                <h:panelGrid columns="2" styleClass="gridTabela">
                    <h:dataTable var="arq" value="#{beanArq.lstPRoduto}">
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="NOME" />
                            </f:facet>
                            <h:outputText value="#{arq.nome}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="MARCA" />
                            </f:facet>
                            <h:outputText value="#{arq.marca}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="PREÇO" />
                            </f:facet>
                            <h:outputText value="#{arq.preco}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="DESCRIÇÃO" />
                            </f:facet>
                            <h:outputText value="#{arq.descricao}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="CATEGORIA" />
                            </f:facet>
                            <h:outputText value="#{arq.categoria}" />
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="QUANTIDADE" />
                            </f:facet>
                            <h:outputText value="#{arq.quantidade}" />
                        </h:column>
                    </h:dataTable>
                </h:panelGrid>
            </h:form>
        </body>
    </html>
</f:view>
