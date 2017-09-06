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
      <version>-SNAPSHOT</version>
      <executions>
         <execution>
            <id>process-dynamic-properties</id>
            <phase>validate</phase>
            <goals>
               <goal>process-dynamic-properties</goal>
            </goals>
            <configuration>
               <operations>
                  <operation>
                     <criteria>
                        <inputProperty>${project.version}</inputProperty>
                        <operator>REGEX</operator>
                        <operand>.*-SNAPSHOT</operand>
                     </criteria>
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
