<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match="/">
	<fo:root>
		<fo:layout-master-set>
				<fo:simple-page-master master-name="kit-pages">
			<fo:region-body margin-top="0.5in" margin-left="0.5in" margin-right="0.5in" margin-bottom="0.5in"/>
		</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence id="sequenceId" master-reference="kit-pages">
				<fo:flow flow-name="xsl-region-body" font-family="Verdana, Arial, Helvetica, sans-serif" font-size="10pt">
					<fo:block text-align="center" border="3" border-after-color="blue">
						<xsl:call-template name="outerStructure"/>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	
	
	
<xsl:template name="outerStructure">
	<fo:block>
		<fo:table table-layout="fixed">
			<fo:table-column column-number="1" column-width="proportional-column-width(100)"/>	
			<fo:table-body>
				
				<fo:table-row keep-together="always">
					<fo:table-cell>
						<fo:block color="#3044b5" font-family="Helvetica" font-size="16pt" font-weight="bold">
								Customer Feedback Report
						</fo:block>
						<fo:block color="#999" space-before="15pt">
					<fo:leader leader-length="100%" leader-pattern="rule" rule-thickness="0.5pt"/>
				</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row keep-together="always">
					<fo:table-cell padding-top="0px" border-width="1px" padding-bottom="5px" border-top-width="0.5px" border-bottom-width="0.5px"> 
					<fo:block>
						<fo:table table-layout="fixed" space-before="5px" padding-right="0px" padding-left="0px" border="0px">
							<fo:table-column column-number="1" column-width="proportional-column-width(1.5)"/>
							<fo:table-column column-number="2" column-width="proportional-column-width(97)"/>
							<fo:table-column column-number="3" column-width="proportional-column-width(1.5)"/>			
							<fo:table-body>
								<fo:table-row keep-together="always">
									<fo:table-cell padding-top="0px" background-color="#ffffff">
										<fo:block text-align="center">
											
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>			
										<fo:block>
											<fo:table table-layout="fixed" space-before="15px" padding-right="0px" padding-left="0px" background-color="#ffffff" border="0px">
											<fo:table-column column-number="1" column-width="proportional-column-width(100)"/>
											<fo:table-body>
												<fo:table-row keep-together="always">
												 <fo:table-cell padding-top="0px">
												 	<fo:block space-before="8pt" font-size="12pt">
												 		<fo:inline font-weight="bold">Please find below the details related to your feedback:</fo:inline>
													</fo:block>	
													<fo:block space-before="10pt">
														 <fo:table table-layout="fixed" space-before="0px" border="0" padding-left="0" padding-right="0" border-right="0px" border-left="0px" border-bottom="1px">
														  <fo:table-column column-number="1" column-width="proportional-column-width(20)"/>															  
														  <fo:table-column column-number="2" column-width="proportional-column-width(70)"/>	
														  <fo:table-column column-number="3" column-width="proportional-column-width(20)"/>
														  <fo:table-column column-number="4" column-width="proportional-column-width(30)"/>
														  <fo:table-column column-number="5" column-width="proportional-column-width(25)"/>
														  <fo:table-column column-number="6" column-width="proportional-column-width(20)"/>
														  <fo:table-body>
															<fo:table-row keep-together="always">
																<fo:table-cell padding-top="0px" border-right-width="1px" border-right-style="solid" border-right-color="#3FB000" background-color="#666f74">
																	<fo:block text-align="left" color="#ffffff" font-weight="bold" font-size="10pt" >									
																		Feedback # 																								
																	</fo:block>
																</fo:table-cell>
																<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#3fb000">
																	<fo:block text-align="left" color="#ffffff" font-weight="bold" font-size="10pt" >									
																		Subject																									
																	</fo:block>
																</fo:table-cell>
																<fo:table-cell padding-top="0px" border-right-width="1px" border-right-style="solid" border-right-color="#3FB000" background-color="#666f74">
																	<fo:block text-align="left" color="#ffffff" font-weight="bold" font-size="10pt" >									
																		Priority 																								
																	</fo:block>
																</fo:table-cell>
																<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#3fb000">
																	<fo:block text-align="left" color="#ffffff" font-weight="bold" font-size="10pt" >									
																		Team Assigned																									
																	</fo:block>
																</fo:table-cell>
																<fo:table-cell padding-top="0px" border-right-width="1px" border-right-style="solid" border-right-color="#3FB000" background-color="#666f74">
																	<fo:block text-align="left" color="#ffffff" font-weight="bold" font-size="10pt" >									
																		Status 																								
																	</fo:block>
																</fo:table-cell>
																<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#3fb000">
																	<fo:block text-align="left" color="#ffffff" font-weight="bold" font-size="10pt" >									
																		Date																									
																	</fo:block>
																</fo:table-cell>
															</fo:table-row>	
															
																<xsl:apply-templates select="feedbackReports/feedbacks"/>
																
															
														</fo:table-body>
													</fo:table>
												</fo:block>
											</fo:table-cell>
										</fo:table-row>	
									</fo:table-body>
								</fo:table>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>								
				</fo:table-body>
			</fo:table>
		</fo:block>		
 	 </fo:table-cell>	
      </fo:table-row>
     </fo:table-body>
   </fo:table>
   </fo:block>
   

	
			<fo:block space-before="10pt" text-align="left" font-size="10pt">
			 <fo:inline font-weight="bold">Note:</fo:inline>
			 <fo:inline>If you have any questions related to this issue, please call our customer care number. When you call, you will need to provide the feedback reference number mentioned above to the customer service representative in order to provide the status related to your feedback.
			 </fo:inline>
			 </fo:block>
		

   <fo:block color="#999" space-before="15pt">
		<fo:leader leader-length="100%" leader-pattern="rule" rule-thickness="0.5pt"/>
  </fo:block>
  
   <fo:block  font-size="10pt" text-align="left" >
   <fo:inline font-weight="bold">
		<xsl:text>Page </xsl:text> <fo:page-number /> <xsl:text> of </xsl:text><fo:page-number-citation-last ref-id="sequenceId"/>	
	</fo:inline>
	<fo:inline text-align="right">
	&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Copyright 2016, University of Siegen, Inc. All rights reserved.
	</fo:inline>
   </fo:block> 
</xsl:template>

<xsl:template match="feedbacks">
	<fo:table-row keep-together="always">
		<fo:table-cell padding-top="0px" border-right-width="1px" border-right-style="solid" border-right-color="#3FB000" background-color="#FFFFFF">
			<fo:block text-align="left" color="#000000" font-weight="bold" font-size="10pt" >									
				<xsl:value-of select="feedbackId"/>																								
			</fo:block>
		</fo:table-cell>
		<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#FFFFFF">
			<fo:block text-align="left" color="#000000" font-weight="bold" font-size="10pt" >									
				<xsl:value-of select="subject"/>																									
			</fo:block>
		</fo:table-cell>
		<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#FFFFFF">
			<fo:block text-align="left" color="#000000" font-weight="bold" font-size="10pt" >									
				<xsl:value-of select="priority"/>																									
			</fo:block>
		</fo:table-cell>
		<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#FFFFFF">
			<fo:block text-align="left" color="#000000" font-weight="bold" font-size="10pt" >									
				<xsl:value-of select="teamAssigned"/>																									
			</fo:block>
		</fo:table-cell>
		<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#FFFFFF">
			<fo:block text-align="left" color="#000000" font-weight="bold" font-size="10pt" >									
				<xsl:value-of select="status"/>																									
			</fo:block>
		</fo:table-cell>
		<fo:table-cell padding-top="0px" border-left-width="1px" border-left-style="solid" border-left-color="#FFFFFF" background-color="#FFFFFF">
			<fo:block text-align="left" color="#000000" font-weight="bold" font-size="10pt" >									
				<xsl:value-of select="substring(feedbackDate,0,11)"/>																									
			</fo:block>
		</fo:table-cell>
	</fo:table-row>
</xsl:template>
</xsl:stylesheet>