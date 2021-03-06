package io.vlingo.wire.channel;

import java.util.function.Consumer;

import io.vlingo.actors.Actor;
import io.vlingo.actors.DeadLetter;
import io.vlingo.actors.LocalMessage;
import io.vlingo.actors.Mailbox;

public class SocketChannelSelectionProcessor__Proxy implements SocketChannelSelectionProcessor {

  private static final String closeRepresentation1 = "close()";
  private static final String processRepresentation2 = "process(java.nio.channels.SelectionKey)";

  private final Actor actor;
  private final Mailbox mailbox;

  public SocketChannelSelectionProcessor__Proxy(final Actor actor, final Mailbox mailbox){
    this.actor = actor;
    this.mailbox = mailbox;
  }

  public void close() {
    if (!actor.isStopped()) {
      final Consumer<SocketChannelSelectionProcessor> consumer = (actor) -> actor.close();
      mailbox.send(new LocalMessage<SocketChannelSelectionProcessor>(actor, SocketChannelSelectionProcessor.class, consumer, closeRepresentation1));
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, closeRepresentation1));
    }
  }
  public void process(java.nio.channels.SelectionKey arg0) {
    if (!actor.isStopped()) {
      final Consumer<SocketChannelSelectionProcessor> consumer = (actor) -> actor.process(arg0);
      mailbox.send(new LocalMessage<SocketChannelSelectionProcessor>(actor, SocketChannelSelectionProcessor.class, consumer, processRepresentation2));
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, processRepresentation2));
    }
  }
}
