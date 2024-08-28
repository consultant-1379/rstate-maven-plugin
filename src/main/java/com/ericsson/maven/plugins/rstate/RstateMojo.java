package com.ericsson.maven.plugins.rstate;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import com.ericsson.maven.plugins.baseconverter.RstateConverter;


/**
 * Goal which takes the RState string and outputs corresponding Mavenized version number
 *
 * @goal rstate
 * 
 * @phase initialize
 */
public class RstateMojo
    extends AbstractMojo
{
    /**
     * @parameter expression="${project.version}" default-value="1.0.1"
     * @required
     */
    private String version;

    /**
     * The Maven project.
     *
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private org.apache.maven.project.MavenProject mavenProject;

    public void execute()
        throws MojoExecutionException
    {
    	String mavenversion = RstateConverter.convertNumeric2Rstate( version );
	mavenProject.getProperties().put( "ericsson.rstate", mavenversion );
    	getLog().info( "Using RState = " + mavenversion );
    }

}
