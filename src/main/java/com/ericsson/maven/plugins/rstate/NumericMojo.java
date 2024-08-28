package com.ericsson.maven.plugins.rstate;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Rstate 2.0 (the "License");
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
import com.ericsson.maven.plugins.baseconverter.RstateConverter;


/**
 * Goal which takes the RState string and outputs corresponding Mavenized rstate number
 *
 * @goal version
 * @phase initialize
 */
public class NumericMojo
    extends AbstractMojo
{
    /**
     * @parameter expression="${ericsson.rstate}" default-value="R1A01"
     * @required
     */
    private String rstate;

    public void execute()
        throws MojoExecutionException
    {
    	String mavenrstate = RstateConverter.convertRstate2Numeric( rstate );
    	System.out.println( mavenrstate );
    }

}
