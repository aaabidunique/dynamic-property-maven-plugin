package com.github.aaabidunique.dynamicproperty.mojo;

import java.util.List;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.github.aaabidunique.dynamicproperty.domain.Operation;
import com.github.aaabidunique.dynamicproperty.domain.OperationProperty;
import com.github.aaabidunique.dynamicproperty.worker.DynamicPropertyWorker;

@Mojo(name = "process-dynamic-properties", defaultPhase = LifecyclePhase.VALIDATE)
public class DynamicPropertyMojo extends AbstractMojo {

	@Parameter(defaultValue = "${project}", readonly = false, required = true)
	private MavenProject project;

	@Parameter
	private List<Operation> operations;

	public void execute() throws MojoExecutionException {
		Properties properties = project.getProperties();

		getLog().info("Performing Dynamic Property Operation");

		for (Operation eachOperation : operations) {
			List<OperationProperty> operationPropertyList = DynamicPropertyWorker.getOperationPropertyList(eachOperation);

			DynamicPropertyWorker.updateProperty(properties, operationPropertyList);

			for (OperationProperty eachOperationProperty : operationPropertyList) {
				getLog().info("Setting key '" + eachOperationProperty.getKey() + "' to '" + eachOperationProperty.getValue() + "'...");
			}
		}
	}
}
