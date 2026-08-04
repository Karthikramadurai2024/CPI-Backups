<?xml version="1.0" encoding="UTF-8"?>
<!-- Get Site ID and Contact ID-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns5="http://sim.aravo.com/soapservices/v4_2/SupplierService"
xmlns:ns6="http://sim.aravo.com/datamodel/2013/01/links"> 
<xsl:param name="supplierId"/>
<xsl:output omit-xml-declaration="no" indent="yes"/>
<xsl:template match="ns5:getSuppliersResponse/return/supplier">
<Output>
    <xsl:for-each select="contacts">
      <request>
            <supplierContactId><xsl:value-of select="ns6:targetInternalId"/></supplierContactId>
      </request>
    </xsl:for-each>
    <xsl:for-each select="businessRelationships[ns6:targetSubtype = 'Site']">
          <request>
                <id><xsl:value-of select="ns6:targetInternalId"/></id>
                <subtypeKey>Site</subtypeKey>
                <linkActive><xsl:value-of select="ns6:linkActive"/></linkActive>
          </request>
    </xsl:for-each>
</Output>
</xsl:template>
<xsl:template match="text()" priority="-100"> </xsl:template>
</xsl:stylesheet>
