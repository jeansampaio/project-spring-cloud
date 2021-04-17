ARG ELK_VERSION

# https://www.docker.elastic.co/
FROM docker.elastic.co/beats/filebeat:${ELK_VERSION}

RUN mkdir /usr/share/filebeat/dockerlogs 
RUN chown -R root /usr/share/filebeat/ 
RUN chmod -R go-w /usr/share/filebeat/
