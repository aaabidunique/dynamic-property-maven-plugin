# dynamic-property-maven-plugin
A maven plugin for creating property on the fly based on condition.

[![](https://jitpack.io/v/aaabidunique/dynamic-property-maven-plugin.svg)](https://jitpack.io/#aaabidunique/dynamic-property-maven-plugin)

#### pom.xml entry
##### Adding Repository  

```maven
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

##### Adding plugin

```maven
<plugins>
...
   <plugin>
      <groupId>com.github.aaabidunique</groupId>
      <artifactId>dynamic-property-maven-plugin</artifactId>
      <version>1.0.1</version>
      <executions>
         <execution>
            <id>process-dynamic-properties</id>
            <!-- should  be validate phase since properties need to be operated on before project build starts-->
            <phase>validate</phase>
            <goals>
				<!-- there is only one goal present to perform dynamic property generation/substitution of values -->
               <goal>process-dynamic-properties</goal>
            </goals>
            <configuration>
               <operations>
				  <!-- multiple operation support -->
                  <operation>
					<!-- criteria on which operation need to be performed -->
                     <criteria>
                        <inputProperty>${project.version}</inputProperty>
                        <!-- available operator are : EQUALS,EQUALS_IGNORE_CASE,CONTAINS,REGEX -->
                        <operator>REGEX</operator>
                        <operand>.*-SNAPSHOT</operand>
                     </criteria>
                     <!-- operation in case above criteria in true -->
                     <trueOperations>
                        <operationProperty>
                           <key>your_key1</key>
                           <value>your_value1</value>
                        </operationProperty>
                        <operationProperty>
                           <key>your_key2</key>
                           <value>your_value2</value>
                        </operationProperty>
                     </trueOperations>
                     <!-- operation in case above criteria in false -->
                     <falseOperations>
                        <operationProperty>
                           <key>your_key1</key>
                           <value>your_value1</value>
                        </operationProperty>
                        <operationProperty>
                           <key>your_key2</key>
                           <value>your_value2</value>
                        </operationProperty>
                     </falseOperations>
                  </operation>
               </operations>
            </configuration>
         </execution>
      </executions>
   </plugin>
   ...
</plugins>
```

Documents coming soon...
