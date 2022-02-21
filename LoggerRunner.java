import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerRunner {
private static final Logger LOG = LoggerFactory.getLogger(LoggerRunner.class);



try{
  List<String> list = new ArrayList<>();
}
Catch(Exception e){
LOG.info(
       " Logger was not specified. "
           + "Defaulting to files from the Employee  list : will stage {} files. "
           + "Enable logging at DEBUG level to see which files will be staged.",
           list.size());
   LOG.debug("Employee list elements: {}", list);
}


}
