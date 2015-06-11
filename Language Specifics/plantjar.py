
#Script for extracting the language specifics from the 
# plantuml jar file

# output saved in output.txt
import subprocess

jarput = subprocess.check_output(['java', '-jar', 'plantuml.jar', '-language'])
f = open('output.txt',"w")
f.write(jarput)
f.close()