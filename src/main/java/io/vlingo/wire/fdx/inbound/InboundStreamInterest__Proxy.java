// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.wire.fdx.inbound;

import java.util.function.Consumer;

import io.vlingo.actors.Actor;
import io.vlingo.actors.LocalMessage;
import io.vlingo.actors.Mailbox;
import io.vlingo.wire.message.RawMessage;
import io.vlingo.wire.node.AddressType;

public class InboundStreamInterest__Proxy implements InboundStreamInterest {
  private final Actor actor;
  private final Mailbox mailbox;

  public InboundStreamInterest__Proxy(final Actor actor, final Mailbox mailbox) {
    this.actor = actor;
    this.mailbox = mailbox;
  }
  
  @Override
  public void handleInboundStreamMessage(final AddressType addressType, final RawMessage message) {
    final Consumer<InboundStreamInterest> consumer = (actor) -> actor.handleInboundStreamMessage(addressType, message);
    mailbox.send(new LocalMessage<InboundStreamInterest>(actor, InboundStreamInterest.class, consumer, "handleInboundStreamMessage(AddressType, RawMessage)"));
  }
}