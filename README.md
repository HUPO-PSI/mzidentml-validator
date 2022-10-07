# mzidentml-validator

[![Java CI with Maven](https://github.com/ypriverol/mzidentml-validator/actions/workflows/maven.yml/badge.svg)](https://github.com/ypriverol/mzidentml-validator/actions/workflows/maven.yml)

mzidentml validator ui and command line tool allows developers of the mzIdentML standard to validate their implementation using the following tools.

Disclaimer
----------
This validator is not part of the formal document process and is still under development.
At this stage, the validation is neither complete nor has been thoroughly tested for correctness.
The current version should be regarded as a prototype and proof of concept implementation not as final version!

## mzidentml-validator-{version}-gui.jar 

The GUI version is a desktop tool that enable users to configure among others the level of errors (WARNING, ERROR, FAILS), the ontologies to be used to validate semantically the files, etc. The jar can be executed as: 

```bash
jar -jar mzidentml-validator-{version}-gui.jar 
```

## mzidentml-validator-{version}-cmd.jar 

The commandline tool enables to validate the mzidentml using the commandline. When the tool get executed the following message defines the parameters needed by the tool: 

```bash 
java -jar mzidentml-validator-{version}-cmd.jar
Usage:

psidev.psi.pi.validator.MzIdentMLValidator <ontology_config_file> <cv_mapping_config_file> <coded_rules_config_file> <xml_file_filter_file> <mzml_file_to_validate> <message_level>
Where message level can be:
- DEBUG
- INFO
- WARN
- ERROR
- FATAL

```

The following files are needed fot the tool: 
- ontology_config_file: It can be found the default configuration file here https://raw.githubusercontent.com/ypriverol/mzidentml-validator/main/src/main/resources/ontologies.xml
- cv_mapping_config_file: It can be found the default configuration file here ... 
- coded_rules_config_file: It can be found the default configuration file here ... 
- xml_file_filter_file: It can be found the default configuration file here ... 
- mzml_file_to_validate: The mzidentml that will be validated
- message_level: One of the following values: **DEBUG, INFO, WARN, ERROR, FATAL**

### Contributing

Please feel free to contribute with the following project. 