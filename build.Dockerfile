FROM openjdk:8-jdk-alpine

ENV GRADLE_VERSION=5.6.1
ENV HOME /
ARG CLOUD_SDK_VERSION=260.0.0
ARG SHA256SUM=4a52db98684fcf013458d9a1c16652cfe7d955d1038bb9f0c89928e345f7a61b

RUN apk add --no-cache --update curl python bash libstdc++ && rm -rf /var/cache/apk/*

# Install gcloud CLI
RUN curl -O https://dl.google.com/dl/cloudsdk/channels/rapid/downloads/google-cloud-sdk-${CLOUD_SDK_VERSION}-linux-x86_64.tar.gz
RUN echo "${SHA256SUM}  google-cloud-sdk-${CLOUD_SDK_VERSION}-linux-x86_64.tar.gz" > google-cloud-sdk-${CLOUD_SDK_VERSION}-linux-x86_64.tar.gz.sha256
RUN sha256sum -c google-cloud-sdk-${CLOUD_SDK_VERSION}-linux-x86_64.tar.gz.sha256
RUN tar xzf google-cloud-sdk-${CLOUD_SDK_VERSION}-linux-x86_64.tar.gz
ENV PATH /google-cloud-sdk/bin:$PATH
RUN gcloud config set core/disable_usage_reporting true
RUN gcloud config set component_manager/disable_update_check true
VOLUME ["/.config"]

# Install Gradle 5.6.1
RUN curl https://downloads.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip > gradle.zip && \
    unzip gradle.zip && \
    rm gradle.zip

ENV PATH=${PATH}:/gradle-${GRADLE_VERSION}/bin
